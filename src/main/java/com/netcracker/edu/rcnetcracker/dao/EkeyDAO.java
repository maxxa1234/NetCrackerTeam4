package com.netcracker.edu.rcnetcracker.dao;

import com.netcracker.edu.rcnetcracker.model.Ekey;

import com.netcracker.edu.rcnetcracker.servicies.requestParam.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestParam.criteria.SortCriteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EkeyDAO implements DAO<Ekey> {

    @Override
    public Ekey getById(Long id) {
        return null;
    }

    @Override
    public void create(Ekey object) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Long id) {

    }

    @Override
    public List<Ekey> findPagination(SortCriteria sortCriteria) {
        return null;
    }

    @Override
    public List<Ekey> getFiltrated(List<SearchCriteria> parameters) {
        return null;
    }
}
