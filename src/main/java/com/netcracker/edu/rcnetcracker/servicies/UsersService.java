package com.netcracker.edu.rcnetcracker.servicies;

import com.netcracker.edu.rcnetcracker.model.User;
import com.netcracker.edu.rcnetcracker.servicies.requestParam.RequestParams;
import org.springframework.data.domain.Page;

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
    public Page<User> getAll(RequestParams params) {
        return null;
    }

    public User findUserByEmail(String email) {

        return null;
    }
}
