package com.netcracker.edu.rcnetcracker.servicies;

import com.netcracker.edu.rcnetcracker.db.access.OracleDbAccess;
import com.netcracker.edu.rcnetcracker.model.User;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SortCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class UsersService implements Service<User> {

    private final OracleDbAccess oracleDbAccess;

    @Autowired
    public UsersService(OracleDbAccess oracleDbAccess) {
        this.oracleDbAccess = oracleDbAccess;
    }

    @Override
    public User getById(Long id) {
        return oracleDbAccess.getById(User.class, id);
    }

    @Override
    public void create(User object) {
        oracleDbAccess.insert(object);
    }

    @Override
    public void delete(Long id) {
        oracleDbAccess.delete(User.class, id);
    }

    @Override
    public Integer update(User object) {
        return oracleDbAccess.update(object);
    }

    @Override
    public Page<User> getAll(Pageable pageable, List<SearchCriteria> filter, SortCriteria sort) {
        return oracleDbAccess.selectPage(User.class, pageable, filter, sort);
    }

    public User findUserByEmail(String email) {

        return null;
    }
}
