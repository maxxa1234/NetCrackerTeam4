package com.netcracker.edu.rcnetcracker.servicies.requestParam;

import com.netcracker.edu.rcnetcracker.servicies.requestParam.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestParam.criteria.SortCriteria;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class Director {

    protected RequestParamsBuilder builder;

    public void setBuilder (RequestParamsBuilder builder){
        this.builder = builder;
    }

    public RequestParams buildRequestParams(Pageable pageable, List<SearchCriteria> filters, SortCriteria sortCriteria){
        builder.createRequestParams();
        builder.buildFilter(filters, pageable);
        builder.buildSort(sortCriteria, pageable);

        return builder.getRequestParams();
    }
}
