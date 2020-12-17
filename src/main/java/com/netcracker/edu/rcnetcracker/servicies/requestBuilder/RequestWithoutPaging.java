package com.netcracker.edu.rcnetcracker.servicies.requestBuilder;

import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SortCriteria;

import java.util.List;

public class RequestWithoutPaging extends RequestBuilder {


    public RequestWithoutPaging(Request request, List<SearchCriteria> filter, SortCriteria sort) {
        super(request, filter, sort, null);
    }

    @Override
    public void buildSelectBlock() {

    }

    @Override
    public void buildFilterBlock() {
        for (SearchCriteria criteria : filter) {
            request.filterBlock.append(" AND \"" + criteria.getKey() + "\" " + criteria.getValue() + " ");
        }
        if (sort != null) {
            request.setFilterBlock(new StringBuilder(
                    request.filterBlock.toString() + " order by \"" + sort.getProperty() + "\" " + sort.getDirection() + " "
            ));
        }
    }
}
