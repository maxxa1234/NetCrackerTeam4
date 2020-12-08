package com.netcracker.edu.rcnetcracker.dao;

import com.netcracker.edu.rcnetcracker.model.Entrance;

import com.netcracker.edu.rcnetcracker.servicies.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.criteria.SortCriteria;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EntranceDAO implements DAO<Entrance> {
    @Override
    public Entrance getById(Long id) {
        return null;
    }

    @Override
    public void create(Entrance object) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Long id) {

    }

    @Override
    public List<Entrance> findPagination(SortCriteria sortCriteria) {
        return null;
    }

    @Override
    public List<Entrance> getFiltrated(List<SearchCriteria> parameters) {
        return null;
    }
}
