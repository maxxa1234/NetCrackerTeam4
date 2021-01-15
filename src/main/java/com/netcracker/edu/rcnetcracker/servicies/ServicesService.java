package com.netcracker.edu.rcnetcracker.servicies;

import com.netcracker.edu.rcnetcracker.db.access.OracleDbAccess;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SortCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class ServicesService implements Service<com.netcracker.edu.rcnetcracker.model.Service> {

    private final OracleDbAccess oracleDbAccess;

    @Autowired
    public ServicesService(OracleDbAccess oracleDbAccess) {
        this.oracleDbAccess = oracleDbAccess;
    }

    @Override
    public com.netcracker.edu.rcnetcracker.model.Service getById(Long id) {
        return oracleDbAccess.getById(com.netcracker.edu.rcnetcracker.model.Service.class, id);
    }

    @Override
    public boolean create(com.netcracker.edu.rcnetcracker.model.Service object) {
        if (oracleDbAccess.insert(object) == 1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean delete(Long id) {
        if (oracleDbAccess.delete(com.netcracker.edu.rcnetcracker.model.Service.class, id) == 1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean update(com.netcracker.edu.rcnetcracker.model.Service object) {
        if (oracleDbAccess.update(object) == 1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Page<com.netcracker.edu.rcnetcracker.model.Service> getAll(Pageable pageable, List<SearchCriteria> filter, SortCriteria sort) {
        return oracleDbAccess.selectPage(com.netcracker.edu.rcnetcracker.model.Service.class, pageable, filter, sort);
    }
}
