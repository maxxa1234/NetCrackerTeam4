package com.netcracker.edu.rcnetcracker.servicies;

import com.netcracker.edu.rcnetcracker.servicies.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.criteria.SortCriteria;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class RequestBuilder {

    private Pageable pageable;
    private List<SearchCriteria> filterCriteria;
    private SortCriteria sortCriteria;

    public RequestBuilder(int page, int size) {
        filterCriteria = new ArrayList<>();
        pageable = PageRequest.of(page, size);
    }

    public RequestBuilder(List<SearchCriteria> filterCriteria, SortCriteria sortCriteria) {//
        this.filterCriteria = filterCriteria;
        this.sortCriteria = sortCriteria;
    }

    public List<SearchCriteria> getFilterCriteria() {
        return filterCriteria;
    }

    public boolean addFilterCriteria(String key, String value){
        return filterCriteria.add(new SearchCriteria(key, value.substring(1), value.substring(0, 1)));
    }

    public Pageable getPageable() {
        return pageable;
    }

    public SortCriteria getSortCriteria() {
        return sortCriteria;
    }

    public void setSortCriteria(SortCriteria sortCriteria) {
        this.sortCriteria = sortCriteria;
    }
}
