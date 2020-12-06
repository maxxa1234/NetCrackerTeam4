package com.netcracker.edu.rcnetcracker.dao;

import com.netcracker.edu.rcnetcracker.servicies.filtering.SearchCriteria;
import org.springframework.data.domain.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EntityDAO<T> {

    private final DAO service;

    public EntityDAO(DAO service) {
        this.service = service;
    }

    public Page<T> getAll(int page, int size, List<SearchCriteria> filter, String sort){
        Page<T> resultPage;
        List<T> listOfResultElements;
        if (filter != null){
            listOfResultElements = service.getFiltrated(filter);
            resultPage = new PageImpl<>(listOfResultElements, getPageable(page, size, sort), listOfResultElements.size());
        }else {
            resultPage = service.findPagination((PageRequest) getPageable(page, size, sort));
        }
        return resultPage;
    }

    private Pageable getPageable(int page, int size, String sort){
        if (sort != null){
            String sortParams [] = new String[2];
            Pattern pattern = Pattern.compile("^(\\w+)\\:\\s?(ASC|DESC)$");
            Matcher matcher = pattern.matcher(sort);
            while (matcher.find()){
                sortParams[0] = matcher.group(1);
                sortParams[1] = matcher.group(2);
            }
            if (sortParams[1] == null){
                throw new IllegalArgumentException();
            }
            if (sortParams[1].equals("ASC")){
                return PageRequest.of(page, size, Sort.Direction.ASC, sortParams[0]);
            }else if (sortParams[1].equals("DESC")){
                return PageRequest.of(page, size, Sort.Direction.DESC, sortParams[0]);
            }
        }
        return PageRequest.of(page, size);
    }

}
