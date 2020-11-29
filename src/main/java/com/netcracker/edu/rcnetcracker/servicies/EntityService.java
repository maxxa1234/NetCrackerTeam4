package com.netcracker.edu.rcnetcracker.servicies;

import com.netcracker.edu.rcnetcracker.servicies.filtering.EntitySpecification;

import java.util.List;

public interface EntityService<T> {

    //return elements for 1 page
    List<T> findPagination(int size);
    //return filtrated elements with specified filter
    List<T> getFiltrated(EntitySpecification<T> specification);
}
