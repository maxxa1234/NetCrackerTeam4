package com.netcracker.edu.rcnetcracker.servicies.criteria;
/*
* Class to create criteria for filtering
* key - field name
* value - parameter value
* */

public class SearchCriteria {

    private String key;
    private Object value;
    private String operation;

    public SearchCriteria(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public SearchCriteria(String key, Object value, String operation) {
        super();
        this.key = key;
        this.value = value;
        this.operation = operation;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

}
