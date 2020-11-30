package com.netcracker.edu.rcnetcracker.servicies.filtering;

public class SearchCriteria {

    private String key;
    private String operation;
    private Object value;

    public SearchCriteria(String key, String operator, Object value) {
        this.key = key;
        this.operation = operator;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getOperation() {
        return operation;
    }

    public Object getValue() {
        return value;
    }

}