package com.netcracker.edu.rcnetcracker.servicies;


import com.netcracker.edu.rcnetcracker.servicies.requestParam.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestParam.criteria.SortCriteria;
import org.springframework.data.domain.*;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EntityService<T> {

    private final Service service;

    public EntityService(Service service) {
        this.service = service;
    }

    public Page<T> getAll(int page, int size, List<SearchCriteria> filter, String sort) {
//        Page<T> resultPage;
//        List<T> listOfResultElements;
//        if (filter.size() != 0) {
//            listOfResultElements = service.getFiltrated(filter);
//            resultPage = new PageImpl<>(listOfResultElements, getPageable(page, size, sort), listOfResultElements.size());
//        } else {
//            listOfResultElements = service.findPagination(getSortCriteria(getPageable(page, size, sort)));
//            resultPage = new PageImpl<>(listOfResultElements, getPageable(page, size, sort), listOfResultElements.size());
//        }
//        return resultPage;
        return null;
    }

    private SortCriteria getSortCriteria(Pageable pageable) {
        SortCriteria sortCriteria = new SortCriteria();

        if (pageable.getPageNumber() != 0 && pageable.getPageSize() != 0){

        }
        Iterator<Sort.Order> orderIterator = pageable.getSort().iterator();
        Sort.Order order = null;
        while (orderIterator.hasNext()){
            order = orderIterator.next();
        }
        if (order != null) {
            sortCriteria.setDirection(order.getDirection().toString());
            sortCriteria.setProperty(order.getProperty());
        }

        return sortCriteria;
    }

    private Pageable getPageable(int page, int size, String sort) {
        if (sort != null) {
            String sortParams[] = new String[2];
            Pattern pattern = Pattern.compile("^(\\w+)\\:\\s?(ASC|DESC)$");
            Matcher matcher = pattern.matcher(sort);
            while (matcher.find()) {
                sortParams[0] = matcher.group(1);
                sortParams[1] = matcher.group(2);
            }
            if (sortParams[1] == null) {
                throw new IllegalArgumentException();
            }
            if (sortParams[1].equals("ASC")) {
                return PageRequest.of(page, size, Sort.Direction.ASC, sortParams[0]);
            } else if (sortParams[1].equals("DESC")) {
                return PageRequest.of(page, size, Sort.Direction.DESC, sortParams[0]);
            }
        }
        return PageRequest.of(page, size, Sort.unsorted());
    }

}
