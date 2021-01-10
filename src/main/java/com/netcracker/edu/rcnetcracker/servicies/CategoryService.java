package com.netcracker.edu.rcnetcracker.servicies;

import com.netcracker.edu.rcnetcracker.db.access.OracleDbAccess;
import com.netcracker.edu.rcnetcracker.model.Category;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SortCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class CategoryService implements Service<Category> {

    private final OracleDbAccess oracleDbAccess;

    public CategoryService(OracleDbAccess oracleDbAccess) {
        this.oracleDbAccess = oracleDbAccess;
    }

    @Override
    public Category getById(Long id) {
        return oracleDbAccess.getById(Category.class, id);
    }

    @Override
    public boolean create(Category object) {
        if(oracleDbAccess.insert(object) ==1)
            return true;
        else return false;
    }

    @Override
    public boolean delete(Long id) {
        if(oracleDbAccess.delete(Category.class, id) ==1)
            return true;
        else return false;
    }

    @Override
    public boolean update(Category object) {
        if(oracleDbAccess.update(object) == 1)
            return true;
        else return false;
    }

    @Override
    public Page<Category> getAll(Pageable pageable, List<SearchCriteria> filter, SortCriteria sort) {
        return oracleDbAccess.selectPage(Category.class, pageable, filter, sort);
    }
}
