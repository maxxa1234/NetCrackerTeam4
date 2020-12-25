package com.netcracker.edu.rcnetcracker.servicies;

import com.netcracker.edu.rcnetcracker.db.access.OracleDbAccess;
import com.netcracker.edu.rcnetcracker.model.Entrance;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SortCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class EntranceService implements Service<Entrance> {

    @Autowired
    private OracleDbAccess oracleDbAccess;

    @Override
    public Entrance getById(Long id) {
        return oracleDbAccess.getById(Entrance.class, id);
    }

    @Override
    public boolean create(Entrance object) {
        if (oracleDbAccess.insert(object) == 1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        if (oracleDbAccess.delete(Entrance.class, id) == 1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean update(Entrance entrance) {
        if (oracleDbAccess.update(entrance) == 1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Page<Entrance> getAll(Pageable pageable, List<SearchCriteria> filter, SortCriteria sort) {
        return oracleDbAccess.selectPage(Entrance.class, pageable, filter, sort);
    }

}
