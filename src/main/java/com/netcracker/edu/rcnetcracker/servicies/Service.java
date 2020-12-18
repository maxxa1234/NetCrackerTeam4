package com.netcracker.edu.rcnetcracker.servicies;

import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SortCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface Service<T> {

    T getById(Long id);

    void create(T object);

    void delete(Long id);

    Integer update(T object);

    Page<T> getAll(Pageable pageable, List<SearchCriteria> filter, SortCriteria sort);

}
