package com.netcracker.edu.rcnetcracker.dao;

import com.netcracker.edu.rcnetcracker.model.Notification;
import com.netcracker.edu.rcnetcracker.servicies.filtering.SearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationDAO implements DAO<Notification> {
    @Override
    public Notification getById(Long id) {
        return null;
    }

    @Override
    public void create(Notification object) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Long id) {

    }

    @Override
    public Page<Notification> findPagination(PageRequest pageRequest) {
        return null;
    }

    @Override
    public List<Notification> getFiltrated(List<SearchCriteria> parameters) {
        return null;
    }
}