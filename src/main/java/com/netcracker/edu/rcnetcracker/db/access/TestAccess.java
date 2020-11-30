package com.netcracker.edu.rcnetcracker.db.access;

import com.netcracker.edu.rcnetcracker.db.annotations.Attr;
import com.netcracker.edu.rcnetcracker.db.annotations.Processor;
import com.netcracker.edu.rcnetcracker.model.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class TestAccess {

    private static JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static <T extends BaseEntity> List<T> selectAll(Class<T> clazz) {
        List<Attr> attributes = Processor.getAttributes(clazz);
        List<T> list = jdbcTemplate.query(getSelectAllStatement(clazz, attributes), new RowMapper<T>() {
            public T mapRow(ResultSet rs, int rowNum) throws SQLException {
                T obj = null;
                try {
                    obj = clazz.getDeclaredConstructor().newInstance();
                    for(int i = 0; i < attributes.size(); i++) {

                        attributes.get(i).field.setAccessible(true);
                        attributes.get(i).field.set(obj, rs.getObject((attributes.get(i).field.getName()),
                                attributes.get(i).field.getType()));
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

    private static String getSelectAllStatement(Class<?> clazz, List<Attr> attributes) {
        StringBuilder selectBlock = new StringBuilder("SELECT o.object_id id, o.name name, o.description description ");
        StringBuilder fromBlock = new StringBuilder("FROM OBJECTS o ");
        StringBuilder whereBlock = new StringBuilder("WHERE o.object_type_id = " + Processor.getObjtypeId(clazz) + " ");

        for(int i = 0; i < attributes.size(); i++) {
            if (attributes.get(i).isBaseAttr) {
                continue;
            }
            selectBlock.append(", a").append(i).append(".").append(attributes.get(i).valueType.getValueType())
                    .append(" \"").append(attributes.get(i).field.getName()).append("\" ");
            fromBlock.append(", ").append(attributes.get(i).valueType.getTable()).append(" a").append(i).append(" ");
            whereBlock.append("AND o.object_id = a").append(i).append(".object_id ").append("AND a")
                    .append(i).append(".attr_id = ").append(attributes.get(i).id).append(" ");
        }

        return selectBlock.toString() + fromBlock.toString() + whereBlock.toString();
    }
}
