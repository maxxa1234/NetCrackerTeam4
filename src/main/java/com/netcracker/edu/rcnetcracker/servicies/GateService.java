package com.netcracker.edu.rcnetcracker.servicies;

import com.netcracker.edu.rcnetcracker.model.Gate;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class GateService {

    public String getHello() {
        return "hello2";
    }

    public List<Gate>  receiveGates() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "context.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql =    "SELECT o.object_id id, attr_name.value name, attr_desc.value description\n" +
                "FROM    objects o, objtype o_t,\n" +
                "        attributes attr_name, attrtype attr_t_name,\n" +
                "        attributes attr_desc, attrtype attr_t_desc\n" +
                "WHERE   o.OBJECT_TYPE_ID = o_t.OBJECT_TYPE_ID\n" +
                "AND     o_t.code = 'Gate'\n" +
                "\n" +
                "AND     attr_name.ATTR_ID = attr_t_name.ATTR_ID\n" +
                "AND     attr_name.object_id = o.object_id\n" +
                "AND     attr_t_name.code = 'name'\n" +
                "\n" +
                "AND     attr_desc.ATTR_ID = attr_t_desc.ATTR_ID\n" +
                "AND     attr_desc.object_id = o.object_id\n" +
                "AND     attr_t_desc.code = 'description'";
        List<Gate> gates = jdbcTemplate.query(sql, new RowMapper<Gate>() {
            public Gate mapRow(ResultSet rs, int rowNum) throws SQLException {
                Gate g = new Gate();
                g.setId(rs.getObject("id", Long.class));
                g.setName(rs.getString("name"));
                g.setDescription(rs.getString("description"));
                return g;
            }
        });
        return gates;
    }

}
