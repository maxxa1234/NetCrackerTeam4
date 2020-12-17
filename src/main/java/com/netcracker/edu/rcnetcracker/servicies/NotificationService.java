package com.netcracker.edu.rcnetcracker.servicies;

import com.netcracker.edu.rcnetcracker.model.Notification;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SortCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class NotificationService implements Service<Notification> {
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
    public Integer update(Notification object) {
        return null;
    }

    @Override
    public Page<Notification> getAll(Pageable pageable, List<SearchCriteria> filter, SortCriteria sort) {
        return null;
    }

}
