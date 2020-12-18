package com.netcracker.edu.rcnetcracker.servicies;

import com.netcracker.edu.rcnetcracker.model.User;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SortCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class UsersService implements Service<User> {

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
    public Integer update(User object) {
        return null;
    }

    @Override
    public Page<User> getAll(Pageable pageable, List<SearchCriteria> filter, SortCriteria sort) {
        return null;
    }

    public User findUserByEmail(String email) {

        return null;
    }
}
