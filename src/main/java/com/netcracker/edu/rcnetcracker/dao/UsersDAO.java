package com.netcracker.edu.rcnetcracker.dao;

import com.netcracker.edu.rcnetcracker.model.User;
import com.netcracker.edu.rcnetcracker.servicies.filtering.SearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersDAO implements DAO<User> {

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public void create(User object) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Long id) {

    }

    @Override
    public Page<User> findPagination(PageRequest pageRequest) {
        return null;
    }

    @Override
    public List<User> getFiltrated(List<SearchCriteria> parameters) {
        return null;
    }
}
