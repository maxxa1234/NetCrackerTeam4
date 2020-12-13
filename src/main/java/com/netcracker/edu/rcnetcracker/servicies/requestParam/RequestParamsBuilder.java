package com.netcracker.edu.rcnetcracker.servicies.requestParam;

import com.netcracker.edu.rcnetcracker.servicies.requestParam.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestParam.criteria.SortCriteria;
import org.springframework.data.domain.Pageable;

import java.util.List;

public abstract class RequestParamsBuilder {

    protected RequestParams requestParams;

    public void createRequestParams(){
        requestParams = new RequestParams();
    }

    public abstract void buildFilter(List<SearchCriteria> filters, Pageable pageable);
    public abstract void buildSort(SortCriteria sortCriteria, Pageable pageable);

    public RequestParams getRequestParams(){
        return requestParams;
    }
}
