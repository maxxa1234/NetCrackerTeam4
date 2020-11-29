package com.netcracker.edu.rcnetcracker.servicies.servicesImpl;

import com.netcracker.edu.rcnetcracker.model.Gate;
import com.netcracker.edu.rcnetcracker.servicies.EntityServiceForPaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class GateService implements EntityServiceForPaging<Gate> {

    @Override
    public Page<Gate> findPagination(int page, int size) {
        //        return dao.findAll(new PageRequest(page, size));
        return null;
    }

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
                "AND     attr_t_desc.code = 'description'\n" +
                "ORDER BY id ASC";
        List<Gate> gates = jdbcTemplate.query(sql, (rs, rowNum) -> {
            Gate g = new Gate();
            g.setId(rs.getLong("id"));
            g.setName(rs.getString("name"));
            g.setDescription(rs.getString("description"));
            return g;
        });
        return gates;
    }

    public void createGate(Gate gate){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "context.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);

        String sql1 = "INSERT INTO objects(OBJECT_ID, OBJECT_TYPE_ID)\n" +
                "VALUES (OBJECTS_SEQ.nextval, (SELECT OBJECT_TYPE_ID FROM objtype WHERE code = 'Gate'))";
        String sql2 = "INSERT INTO attributes(ATTR_ID, OBJECT_ID, VALUE)\n" +
                "VALUES(1, OBJECTS_SEQ.currval, '"+ gate.getName() + "')";
        String sql3 = "INSERT INTO attributes(ATTR_ID, OBJECT_ID, VALUE)\n" +
                "VALUES(2, OBJECTS_SEQ.currval, '"  +gate.getDescription() + "')";
        jdbcTemplate.batchUpdate(sql1, sql2, sql3);

    }

}
