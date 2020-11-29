package com.netcracker.edu.rcnetcracker.servicies;

import org.springframework.data.domain.Page;

public interface EntityServiceForPaging<T> {

    public Page<T> findPagination(int page, int size);

}
