package com.netcracker.edu.rcnetcracker.servicies.requestBuilder;

import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SortCriteria;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public abstract class RequestBuilder {

    protected Request request;
    protected List<SearchCriteria> filter;
    protected SortCriteria sort;
    protected Pageable pageable;

    public RequestBuilder(Request request, List<SearchCriteria> filter, SortCriteria sort, Pageable pageable) {
        this.request = request;
        if (filter == null || filter.size() <= 0)
            this.filter = new ArrayList<>();
        else this.filter = filter;
        this.sort = sort;
        this.pageable = pageable;
    }

    public abstract void buildSelectBlock();

    public abstract void buildFilterBlock();

    public Request getRequest() {
        return request;
    }
}
