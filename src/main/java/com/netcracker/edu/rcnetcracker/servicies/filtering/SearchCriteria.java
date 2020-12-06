package com.netcracker.edu.rcnetcracker.servicies.filtering;

/*
* Class to create criteria for filtering
* key - field name
* value - parameter value
* */

public class SearchCriteria {

    private String key;
    private Object value;

    public SearchCriteria(String key, Object value) {
        super();
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

}
