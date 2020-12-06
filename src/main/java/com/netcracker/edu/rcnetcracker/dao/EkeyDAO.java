package com.netcracker.edu.rcnetcracker.dao;

import com.netcracker.edu.rcnetcracker.model.Ekey;
import com.netcracker.edu.rcnetcracker.servicies.filtering.SearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
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
    public Page<Ekey> findPagination(PageRequest pageRequest) {
        Pageable pageRequest1 = pageRequest.first();
        int page = pageRequest1.getPageNumber();
        int size = pageRequest1.getPageSize();
        Sort sort = pageRequest1.getSort();
        List<Sort.Order> orders = new ArrayList<>();
        Iterator<Sort.Order> orderIterator = sort.iterator();
        while (orderIterator.hasNext()){
            orders.add(orderIterator.next());
        }
        System.out.println();
        return null;
    }

    @Override
    public List<Ekey> getFiltrated(List<SearchCriteria> parameters) {
        return null;
    }
}
