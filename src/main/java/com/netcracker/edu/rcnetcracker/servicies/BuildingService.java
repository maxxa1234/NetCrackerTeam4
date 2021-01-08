package com.netcracker.edu.rcnetcracker.servicies;

import com.netcracker.edu.rcnetcracker.db.access.OracleDbAccess;
import com.netcracker.edu.rcnetcracker.model.Building;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SortCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BuildingService implements Service<Building> {

    private final OracleDbAccess oracleDbAccess;

    public BuildingService(OracleDbAccess oracleDbAccess) {
        this.oracleDbAccess = oracleDbAccess;
    }

    @Override
    public Building getById(Long id) {
        return oracleDbAccess.getById(Building.class, id);
    }

    @Override
    public boolean create(Building object) {
        if (oracleDbAccess.insert(object) == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        if (oracleDbAccess.delete(Building.class, id) == 1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean update(Building object) {
        if (oracleDbAccess.update(object) == 1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Page<Building> getAll(Pageable pageable, List<SearchCriteria> filter, SortCriteria sort) {
        return oracleDbAccess.selectPage(Building.class, pageable, filter, sort);
    }
}
