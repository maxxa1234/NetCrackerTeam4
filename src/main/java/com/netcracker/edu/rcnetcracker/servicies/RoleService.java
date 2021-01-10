package com.netcracker.edu.rcnetcracker.servicies;

import com.netcracker.edu.rcnetcracker.db.access.OracleDbAccess;
import com.netcracker.edu.rcnetcracker.model.Role;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SortCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class RoleService implements Service<Role> {

    private final OracleDbAccess oracleDbAccess;

    public RoleService(OracleDbAccess oracleDbAccess) {
        this.oracleDbAccess = oracleDbAccess;
    }

    @Override
    public Role getById(Long id) {
        return oracleDbAccess.getById(Role.class, id);
    }

    @Override
    public boolean create(Role object) {
        if (oracleDbAccess.insert(object) == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        if (oracleDbAccess.delete(Role.class, id) == 1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean update(Role object) {
        if (oracleDbAccess.update(object) == 1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Page<Role> getAll(Pageable pageable, List<SearchCriteria> filter, SortCriteria sort) {
        return oracleDbAccess.selectPage(Role.class, pageable, filter, sort);
    }
}
