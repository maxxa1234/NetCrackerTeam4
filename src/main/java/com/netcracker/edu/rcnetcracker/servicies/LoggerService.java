package com.netcracker.edu.rcnetcracker.servicies;

import com.netcracker.edu.rcnetcracker.db.access.OracleDbAccess;
import com.netcracker.edu.rcnetcracker.model.Logger;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SortCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class LoggerService implements Service<Logger>{

    @Autowired
    private OracleDbAccess oracleDbAccess;

    @Override
    public Logger getById(Long id) {
        return oracleDbAccess.getById(Logger.class, id);
    }

    @Override
    public boolean create(Logger object) {
        if (oracleDbAccess.insert(object) == 1){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean delete(Long id) {
        if (oracleDbAccess.delete(Logger.class, id) == 1){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean update(Logger entrance) {
        if (oracleDbAccess.update(entrance) == 1){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public Page<Logger> getAll(Pageable pageable, List<SearchCriteria> filter, SortCriteria sort) {
        return oracleDbAccess.selectPage(Logger.class, pageable, filter, sort);
    }
}
