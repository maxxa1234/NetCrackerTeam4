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
public class HelloService {

    public String getHello() {
        return "hello2";
    }

    public Gate buildGate() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "context.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        List<Gate> gates = jdbcTemplate.query("SELECT * FROM GATES", new RowMapper<Gate>() {
            public Gate mapRow(ResultSet rs, int rowNum) throws SQLException {
                Gate g = new Gate();
                g.setId(rs.getLong("id"));
                g.setName(rs.getString("name"));
                g.setDescription(rs.getString("description"));
                return g;
            }
        });
        return gates.get(0);
    }

}
