package com.netcracker.edu.rcnetcracker.servicies;

import org.springframework.data.domain.Page;

public interface Service<T> {

    T getById(Long id);

    void create(T object);

    void delete(Long id);

    Integer update(T object);

    Page<T> getAll(RequestBuilder params);

}
