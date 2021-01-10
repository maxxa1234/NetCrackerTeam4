package com.netcracker.edu.rcnetcracker.servicies.requestBuilder;

import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SortCriteria;

import java.util.List;

public class CountElementsRequest extends RequestBuilder {

    public CountElementsRequest(Request request, List<SearchCriteria> filter, SortCriteria sort) {
        super(request, filter, sort, null);
    }

    @Override
    public void buildSelectBlock() {
        request.selectBlock.replace(0, 14, "SELECT COUNT(*) FROM");
    }

    @Override
    public void buildFilterBlock() {
        for (SearchCriteria criteria : filter) {
            request.filterBlock.append(" AND \"" + criteria.getKey() + "\" " + criteria.getValue() + " ");
        }
    }
}
