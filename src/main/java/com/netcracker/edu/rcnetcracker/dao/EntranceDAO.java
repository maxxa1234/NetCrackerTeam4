package com.netcracker.edu.rcnetcracker.dao;

import com.netcracker.edu.rcnetcracker.db.access.TestAccess;
import com.netcracker.edu.rcnetcracker.model.Entrance;
import com.netcracker.edu.rcnetcracker.servicies.filtering.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Page<Entrance> findPagination(PageRequest pageRequest) {
        return null;
    }

    @Override
    public List<Entrance> getFiltrated(List<SearchCriteria> parameters) {
        return testAccess.selectAll(Entrance.class, parameters.toArray(new SearchCriteria[0]));
    }
}
