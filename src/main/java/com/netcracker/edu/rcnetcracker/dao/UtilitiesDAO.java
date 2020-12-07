package com.netcracker.edu.rcnetcracker.dao;

import com.netcracker.edu.rcnetcracker.model.Utility;
import com.netcracker.edu.rcnetcracker.servicies.filtering.SearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilitiesDAO implements DAO<Utility> {

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
    public void update(Long id) {

    }

    @Override
    public Page<Utility> findPagination(PageRequest pageRequest) {
        return null;
    }

    @Override
    public List<Utility> getFiltrated(List<SearchCriteria> parameters) {
        return null;
    }
}
