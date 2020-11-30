package com.netcracker.edu.rcnetcracker.db.access;

import com.netcracker.edu.rcnetcracker.db.annotations.Attr;
import com.netcracker.edu.rcnetcracker.db.annotations.Processor;
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

    public static <T> List<T> selectAll(Class<T> clazz) {
        Attr[] attributes = Processor.getAttributes(clazz);
        List<T> list = jdbcTemplate.query(getSelectAllStatement(clazz, attributes), new RowMapper<T>() {
            public T mapRow(ResultSet rs, int rowNum) throws SQLException {
                T obj = null;
                try {
                    obj = clazz.getDeclaredConstructor().newInstance();
                    Field field;
                    for(int i = 0; i < attributes.length; i++) {
                            field = clazz.getDeclaredField(attributes[i].name);
                            field.setAccessible(true);
                            field.set(obj, rs.getObject((attributes[i].name), attributes[i].clazz));
                    }
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
                return obj;
            }
        });
        return list;
    }

    private static String getSelectAllStatement(Class<?> clazz, Attr[] attributes) {
        StringBuilder selectBlock = new StringBuilder("SELECT o.object_id id, o.name name, o.description description ");
        StringBuilder fromBlock = new StringBuilder("FROM OBJECTS o ");
        StringBuilder whereBlock = new StringBuilder("WHERE o.object_type_id = " + Processor.getObjtypeId(clazz) + " ");

        for(int i = 0; i < attributes.length; i++) {
            selectBlock.append(", a").append(i).append(".").append(attributes[i].valueType.getValueType())
                    .append(" \"").append(attributes[i].name).append("\" ");
            fromBlock.append(", ").append(attributes[i].valueType.getTable()).append(" a").append(i).append(" ");
            whereBlock.append("AND o.object_id = a").append(i).append(".object_id ").append("AND a")
                    .append(i).append(".attr_id = ").append(attributes[i].id).append(" ");
        }

        return selectBlock.toString() + fromBlock.toString() + whereBlock.toString();
    }
}
