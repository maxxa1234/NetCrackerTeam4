package com.netcracker.edu.rcnetcracker.db.access;

import com.netcracker.edu.rcnetcracker.db.annotations.Attr;
import com.netcracker.edu.rcnetcracker.db.annotations.Processor;
import com.netcracker.edu.rcnetcracker.db.annotations.ValueType;
import com.netcracker.edu.rcnetcracker.model.BaseEntity;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.CountElementsRequest;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.Director;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.Request;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.RequestGetByID;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SortCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class OracleDbAccess implements DbAccess {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public <T extends BaseEntity> int update(T obj) {
        Long objId = obj.getId();
        if (isUnique(objId)) {
            return -1;
        }
        ArrayList<String> statements = new ArrayList<>();
        try {
            List<Attr> attributes = Processor.getAttributes(obj.getClass());
            statements.add("UPDATE OBJECTS SET name = '" + obj.getName() + "', description = '" + obj.getDescription()
                    + "' WHERE object_id = " + objId);

            for (int i = 0; i < attributes.size(); i++) {
                attributes.get(i).field.setAccessible(true);
                if (attributes.get(i).valueType == ValueType.BASE_VALUE) {
                    continue;
                }
                if (attributes.get(i).valueType == ValueType.LIST_VALUE) {
                    List<Long> list = (List<Long>) attributes.get(i).field.get(obj);
                    for (int j = 0; j < list.size(); j++) {
                        statements.add(getDeleteStatement(attributes.get(i), objId));
                        statements.add(getInsertStatement(attributes.get(i), objId, list.get(j)));
                    }
                } else {
                    statements.add(getUpdateStatement(attributes.get(i), objId, attributes.get(i).field.get(obj)));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return 1;
        }
        String[] str = new String[0];
        jdbcTemplate.batchUpdate(statements.toArray(str));
        return 0;
    }

    @Override
    public <T extends BaseEntity> int insert(T obj) {
        Long objId = obj.getId();
        if (!isUnique(objId)) {
            return -1;
        }
        ArrayList<String> statements = new ArrayList<>();
        try {
            List<Attr> attributes = Processor.getAttributes(obj.getClass());
            statements.add("INSERT INTO OBJECTS (object_id, name, description, object_type_id) VALUES ('"
                    + objId + "', '" + obj.getName() + "', '" + obj.getDescription() + "', '"
                    + Processor.getObjtypeId(obj.getClass()) + "')");

            for (int i = 0; i < attributes.size(); i++) {
                attributes.get(i).field.setAccessible(true);
                if (attributes.get(i).valueType == ValueType.BASE_VALUE) {
                    continue;
                }
                if (attributes.get(i).valueType == ValueType.LIST_VALUE) {
                    List<Long> list = (List<Long>) attributes.get(i).field.get(obj);
                    for (int j = 0; j < list.size(); j++) {
                        statements.add(getInsertStatement(attributes.get(i), objId, list.get(j)));
                    }
                } else {
                    statements.add(getInsertStatement(attributes.get(i), objId, attributes.get(i).field.get(obj)));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return 1;
        }
        String[] str = new String[0];
        jdbcTemplate.batchUpdate(statements.toArray(str));
        return 0;
    }

    private boolean isUnique(Long id) {
        if (jdbcTemplate.queryForList("SELECT object_id FROM objects WHERE object_id =" + id).isEmpty())
            return true;
        return false;
    }

    @Override
    public <T extends BaseEntity> void delete(Class<T> clazz, Long id) {
        int objTypeId = Processor.getObjtypeId(clazz);
        jdbcTemplate.update("DELETE OBJECTS WHERE OBJECTS.OBJECT_TYPE_ID = " + objTypeId +
                " AND OBJECTS.OBJECT_ID = " + id);
    }

    @Override
    public <T extends BaseEntity> Page<T> selectPage(Class<T> clazz, Pageable pageable, List<SearchCriteria> filter, SortCriteria sort) {
        Director director = new Director(clazz);
        List<T> resultElements = selectAll(clazz, director.buildRequest(pageable, filter, sort).toString());
        Director director1 = new Director(clazz);
        Long countOfElements = selectCountOfFilterElements(director1.buildRequest(new CountElementsRequest(new Request(clazz), filter, sort)).toString());
        if (pageable == null)
            return new PageImpl<>(resultElements);
        if (resultElements.size() != pageable.getPageSize()) {
            pageable = PageRequest.of(pageable.getPageNumber(), resultElements.size());
        }
        return new PageImpl<>(resultElements, pageable, countOfElements);
    }

    private <T extends BaseEntity> List<T> selectAll(Class<T> clazz, String request) {
        List<Attr> attributes = Processor.getAttributes(clazz);
        List<T> list = jdbcTemplate.query(request, new RowMapper<T>() {
            public T mapRow(ResultSet rs, int rowNum) throws SQLException {
                T obj = null;
                try {
                    obj = clazz.getDeclaredConstructor().newInstance();
                    for (int i = 0; i < attributes.size(); i++) {
                        attributes.get(i).field.setAccessible(true);
                        if (attributes.get(i).valueType == ValueType.LIST_VALUE) {
                            attributes.get(i).field.set(obj, getListForObjectAttribute(attributes.get(i),
                                    rs.getLong("id")));
                        } else if (attributes.get(i).valueType == ValueType.REF_VALUE) {
                            List<Long> references = getListForObjectAttribute(attributes.get(i), rs.getLong("id"));
                            Long ref = null;
                            if (!references.isEmpty()) {
                                ref = references.get(0);
                            }
                            attributes.get(i).field.set(obj, ref);
                        } else {
                            attributes.get(i).field.set(obj, rs.getObject((attributes.get(i).field.getName()),
                                    attributes.get(i).field.getType()));
                        }
                    }
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                return obj;
            }
        });
        return list;
    }

    @Override
    public <T extends BaseEntity> T getById(Class<T> clazz, Long id) {
        Director director = new Director(clazz);
        String request = director.buildRequest(new RequestGetByID(new Request(clazz), id)).toString();
        List<T> result = selectAll(clazz, request);
        return result.get(0);
    }

    private Long selectCountOfFilterElements(String request) {
        List<Long> list = jdbcTemplate.queryForList(request, Long.class);
        return list.get(0);
    }

    private List<Long> getListForObjectAttribute(Attr attr, Long objectId) {
        String sql = "SELECT reference \"id\" FROM objreference WHERE attr_id = " + attr.id +
                " AND object_id = " + objectId;
        return jdbcTemplate.queryForList(sql, Long.class);
    }


    private String getInsertStatement(Attr attr, Long objectId, Object value) throws IllegalAccessException {
        String newValue = "'" + value + "'";
        if (value == null) {
            newValue = null;
        }
        return "INSERT INTO " + attr.valueType.getTable() + " (ATTR_ID, OBJECT_ID, "
                + attr.valueType.getValueType() + ") VALUES" + " (" + attr.id + ", " + objectId + ", "
                + newValue + ")";
    }

    private String getDeleteStatement(Attr attr, Long objectId) {
        return "DELETE FROM " + attr.valueType.getTable() + " WHERE attr_id = " + attr.id + " AND object_id = "
                + objectId;
    }

    private String getUpdateStatement(Attr attr, Long objectId, Object value) {
        String newValue = "'" + value + "'";
        if (value == null) {
            newValue = null;
        }
        return "UPDATE " + attr.valueType.getTable() + " SET " + attr.valueType.getValueType() + " = " + newValue
                + " WHERE attr_id = " + attr.id + " AND object_id = " + objectId;
    }
}
