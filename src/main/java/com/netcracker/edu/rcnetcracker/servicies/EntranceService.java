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
    private OracleDbAccess<Entrance> oracleDbAccess;

    @Override
    public Entrance getById(Long id) {
        return oracleDbAccess.getById(Entrance.class, id);
    }

    @Override
    public void create(Entrance object) {
        oracleDbAccess.insert(object);
    }

    @Override
    public void delete(Long id) {
        oracleDbAccess.delete(Entrance.class, id);
    }

    @Override
    public Integer update(Entrance entrance) {
        return oracleDbAccess.update(entrance);
    }

    @Override
    public Page<Entrance> getAll(Pageable pageable, List<SearchCriteria> filter, SortCriteria sort) {
        return oracleDbAccess.selectPage(Entrance.class, pageable, filter, sort);
    }

}
