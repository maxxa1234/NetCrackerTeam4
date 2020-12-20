package com.netcracker.edu.rcnetcracker.servicies.requestBuilder;

import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SortCriteria;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Хранит билдер для запроса и начальный запрос.
 *
 * При вызове метода buildRequest проверяет переменные и используя подходящий билдер строит запрос.
 *
 * Если фильтра нет, то он просто добавит ничего в блок фильтрции.
 * Если нет сортировки, то применяется стандартная сортировка по полю id, по возрастанию ASC
 * */

public class Director {

    protected RequestBuilder builder;
    protected Request request;

    public Director(Class clazz) {
        request = new Request(clazz);
    }

    private void setBuilder(RequestBuilder builder) {
        this.builder = builder;
    }

    public Request buildRequest(Pageable pageable, List<SearchCriteria> filters, SortCriteria sortCriteria) {

        if (pageable == null)
            setBuilder(new RequestWithoutPaging(request, filters, sortCriteria));
        else setBuilder(new RequestWithPaging(request, filters, sortCriteria, pageable));


        builder.buildSelectBlock();
        builder.buildFilterBlock();
        return builder.getRequest();
    }

    public Request buildRequest(RequestBuilder builder) {
        setBuilder(builder);

        this.builder.buildSelectBlock();
        this.builder.buildFilterBlock();

        return this.builder.getRequest();
    }
}
