package com.netcracker.edu.rcnetcracker.servicies;

import com.netcracker.edu.rcnetcracker.db.access.OracleDbAccess;
import com.netcracker.edu.rcnetcracker.model.Entrance;
import com.netcracker.edu.rcnetcracker.model.Notification;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SortCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class NotificationService implements Service<Notification> {

    private final OracleDbAccess oracleDbAccess;

    @Autowired
    public NotificationService(OracleDbAccess oracleDbAccess) {
        this.oracleDbAccess = oracleDbAccess;
    }

    @Override
    public Notification getById(Long id) {
        return oracleDbAccess.getById(Notification.class, id);
    }

    @Override
    public boolean create(Notification object) {
        if (oracleDbAccess.insert(object) == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        if (oracleDbAccess.delete(Notification.class, id) == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(Notification object) {
        if (oracleDbAccess.update(object) == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Page<Notification> getAll(Pageable pageable, List<SearchCriteria> filter, SortCriteria sort) {
        return oracleDbAccess.selectPage(Notification.class, pageable, filter, sort);
    }
}
