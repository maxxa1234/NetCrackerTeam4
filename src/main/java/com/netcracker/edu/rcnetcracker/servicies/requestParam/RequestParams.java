package com.netcracker.edu.rcnetcracker.servicies.requestParam;

import com.netcracker.edu.rcnetcracker.servicies.requestParam.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestParam.criteria.SortCriteria;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class RequestParams {

    private Pageable pageable;
    private List<SearchCriteria> filterCriteria;
    private SortCriteria sortCriteria;

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }

    public void setFilterCriteria(List<SearchCriteria> filterCriteria) {
        this.filterCriteria = filterCriteria;
    }

    public void setSortCriteria(SortCriteria sortCriteria) {
        this.sortCriteria = sortCriteria;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public List<SearchCriteria> getFilterCriteria() {
        return filterCriteria;
    }

    public SortCriteria getSortCriteria() {
        return sortCriteria;
    }
}
