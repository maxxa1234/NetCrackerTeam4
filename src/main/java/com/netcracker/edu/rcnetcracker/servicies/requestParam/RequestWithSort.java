package com.netcracker.edu.rcnetcracker.servicies.requestParam;

import com.netcracker.edu.rcnetcracker.servicies.requestParam.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestParam.criteria.SortCriteria;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class RequestWithSort extends RequestParamsBuilder {
    @Override
    public void buildFilter(List<SearchCriteria> filters, Pageable pageable) {
        requestParams.setFilterCriteria(null);
        requestParams.setPageable(pageable);
    }

    @Override
    public void buildSort(SortCriteria sortCriteria, Pageable pageable) {
        requestParams.setSortCriteria(sortCriteria);
        requestParams.setPageable(pageable);
    }
}
