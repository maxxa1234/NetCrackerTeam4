package com.netcracker.edu.rcnetcracker.dao;




import com.netcracker.edu.rcnetcracker.servicies.requestParam.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestParam.criteria.SortCriteria;

import java.util.List;

public interface DAO<T> {

    T getById(Long id);

    void create(T object);

    void delete(Long id);

    void update(Long id);

    List<T> findPagination(SortCriteria sortCriteria);

    List<T> getFiltrated(List<SearchCriteria> parameters);

}
