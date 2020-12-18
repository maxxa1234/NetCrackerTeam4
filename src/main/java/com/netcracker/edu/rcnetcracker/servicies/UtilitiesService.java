package com.netcracker.edu.rcnetcracker.servicies;

import com.netcracker.edu.rcnetcracker.db.access.OracleDbAccess;
import com.netcracker.edu.rcnetcracker.model.Utility;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SortCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class UtilitiesService implements Service<Utility> {

    @Autowired
    private OracleDbAccess oracleDbAccess;

    @Override
    public Utility getById(Long id) {
        return null;
    }

    @Override
    public void create(Utility object) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Integer update(Utility object) {
        return null;
    }

    @Override
    public Page<Utility> getAll(Pageable pageable, List<SearchCriteria> filter, SortCriteria sort) {
        return null;
    }
}
