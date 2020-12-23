package com.netcracker.edu.rcnetcracker.servicies;

import com.netcracker.edu.rcnetcracker.db.access.OracleDbAccess;
import com.netcracker.edu.rcnetcracker.model.Ekey;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SortCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class EkeyService implements Service<Ekey> {

    private final OracleDbAccess oracleDbAccess;

    @Autowired
    public EkeyService(OracleDbAccess oracleDbAccess) {
        this.oracleDbAccess = oracleDbAccess;
    }

    @Override
    public Ekey getById(Long id) {
        return oracleDbAccess.getById(Ekey.class, id);
    }

    @Override
    public void create(Ekey object) {
        oracleDbAccess.insert(object);
    }

    @Override
    public void delete(Long id) {
        oracleDbAccess.delete(Ekey.class, id);
    }

    @Override
    public Integer update(Ekey object) {
        return oracleDbAccess.update(object);
    }

    @Override
    public Page<Ekey> getAll(Pageable pageable, List<SearchCriteria> filter, SortCriteria sort) {
        return oracleDbAccess.selectPage(Ekey.class, pageable, filter, sort);
    }
}
