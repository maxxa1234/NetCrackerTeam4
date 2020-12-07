package com.netcracker.edu.rcnetcracker.dao;


import com.netcracker.edu.rcnetcracker.servicies.filtering.SearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface DAO<T> {

    T getById(Long id);

    void create(T object);

    void delete(Long id);

    void update(Long id);

    Page<T> findPagination(PageRequest pageRequest);

    List<T> getFiltrated(List<SearchCriteria> parameters);

}
