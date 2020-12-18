package com.netcracker.edu.rcnetcracker.db.access;

import com.netcracker.edu.rcnetcracker.model.BaseEntity;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SortCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DbAccess {
    <T extends BaseEntity> int update(T obj);
    <T extends BaseEntity> int insert(T obj);
    <T extends BaseEntity> void delete(Class<T> clazz, Long id);
    <T extends BaseEntity> Page<T> selectPage(Class<T> clazz, Pageable pageable, List<SearchCriteria> filter, SortCriteria sort);
    <T extends BaseEntity> T getById(Class<T> clazz, Long id);

}
