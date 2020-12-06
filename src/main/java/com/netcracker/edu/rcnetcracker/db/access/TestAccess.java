package com.netcracker.edu.rcnetcracker.db.access;

import com.netcracker.edu.rcnetcracker.db.annotations.Attr;
import com.netcracker.edu.rcnetcracker.db.annotations.Processor;
import com.netcracker.edu.rcnetcracker.db.annotations.ValueType;
import com.netcracker.edu.rcnetcracker.model.BaseEntity;
import com.netcracker.edu.rcnetcracker.servicies.filtering.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class TestAccess {

    private static JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /*public <T extends BaseEntity> int modify (T obj) {

    }*/

    public <T extends BaseEntity> int update (T obj) {
        Long objId = obj.getId();
        if (isUnique(objId)) {
            return -1;
        }
        ArrayList<String> statements = new ArrayList<>();
        try {
            List<Attr> attributes = Processor.getAttributes(obj.getClass());
            statements.add("UPDATE OBJECTS SET name = '" + obj.getName() + "', description = '" + obj.getDescription()
            + "' WHERE object_id = " + objId);

            for(int i = 0; i < attributes.size(); i++) {
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
        String[] str = new String [0];
        jdbcTemplate.batchUpdate(statements.toArray(str));
        return 0;
    }

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

            for(int i = 0; i < attributes.size(); i++) {
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
        String[] str = new String [0];
        jdbcTemplate.batchUpdate(statements.toArray(str));
        return 0;
    }

    private boolean isUnique(Long id) {
        if (jdbcTemplate.queryForList("SELECT object_id FROM objects WHERE object_id =" + id).isEmpty())
            return true;
        return false;
    }

    public <T extends BaseEntity> List<T> selectAll(Class<T> clazz, SearchCriteria[] criterias) {
        List<Attr> attributes = Processor.getAttributes(clazz);
        List<T> list = jdbcTemplate.query(getSelectAllStatement(clazz, attributes, criterias), new RowMapper<T>() {
            public T mapRow(ResultSet rs, int rowNum) throws SQLException {
                T obj = null;
                try {
                    obj = clazz.getDeclaredConstructor().newInstance();
                    for(int i = 0; i < attributes.size(); i++) {
                        attributes.get(i).field.setAccessible(true);
                        if (attributes.get(i).valueType == ValueType.LIST_VALUE) {
                            attributes.get(i).field.set(obj, getListForObjectAttribute(attributes.get(i),
                                    rs.getLong("id")));
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

    private String getSelectAllStatement(Class<? extends BaseEntity> clazz, List<Attr> attributes
            , SearchCriteria[] criterias) {
        StringBuilder selectBlock = new StringBuilder("SELECT o.object_id id, o.name name, o.description description ");
        StringBuilder fromBlock = new StringBuilder("FROM OBJECTS o ");
        StringBuilder whereBlock = new StringBuilder("WHERE o.object_type_id = " + Processor.getObjtypeId(clazz) + " ");

        for (int i = 0; i < attributes.size(); i++) {
            if (attributes.get(i).valueType == ValueType.BASE_VALUE
            ||  attributes.get(i).valueType == ValueType.LIST_VALUE) {
                continue;
            }
            selectBlock.append(", a").append(i).append(".").append(attributes.get(i).valueType.getValueType())
                    .append(" \"").append(attributes.get(i).field.getName()).append("\" ");
            fromBlock.append(", ").append(attributes.get(i).valueType.getTable()).append(" a").append(i).append(" ");
            whereBlock.append("AND o.object_id = a").append(i).append(".object_id ").append("AND a")
                    .append(i).append(".attr_id = ").append(attributes.get(i).id).append(" ");

        }

        for (int i = 0; i < criterias.length; i++) {
            whereBlock.append("AND " + criterias[i].getKey() + criterias[i].getValue() + " ");
        }

        return selectBlock.toString() + fromBlock.toString() + whereBlock.toString();
    }

    private List<Long> getListForObjectAttribute(Attr attr, Long objectId) {
        String sql =    "SELECT reference \"id\" FROM objreference WHERE attr_id = " + attr.id +
                        " AND object_id = " + objectId;
        return jdbcTemplate.queryForList(sql, Long.class);
    }


    private String getInsertStatement (Attr attr, Long objectId, Object value) throws IllegalAccessException {
        String newValue = "'" + value + "'";
        if (value == null) {
            newValue = null;
        }
        return "INSERT INTO " + attr.valueType.getTable() + " (ATTR_ID, OBJECT_ID, "
                + attr.valueType.getValueType() + ") VALUES" + " (" + attr.id + ", " + objectId + ", "
            + newValue + ")";
    }

    private String getDeleteStatement (Attr attr, Long objectId) {
        return "DELETE FROM " + attr.valueType.getTable() + " WHERE attr_id = " + attr.id + " AND object_id = "
        + objectId;
    }

    private String getUpdateStatement (Attr attr, Long objectId, Object value) {
        String newValue = "'" + value + "'";
        if (value == null) {
            newValue = null;
        }
        return "UPDATE " + attr.valueType.getTable() + " SET " + attr.valueType.getValueType() + " = " + newValue
                + " WHERE attr_id = " + attr.id + " AND object_id = " + objectId;
    }
}
