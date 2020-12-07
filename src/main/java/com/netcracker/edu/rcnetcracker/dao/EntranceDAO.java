package com.netcracker.edu.rcnetcracker.dao;

import com.netcracker.edu.rcnetcracker.db.access.TestAccess;
import com.netcracker.edu.rcnetcracker.model.Entrance;
import com.netcracker.edu.rcnetcracker.servicies.filtering.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.filtering.SortCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EntranceDAO implements DAO<Entrance> {

    @Autowired
    private TestAccess testAccess;

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
        return testAccess.selectAll(Entrance.class, parameters.toArray(new SearchCriteria[0]));
    }
}
