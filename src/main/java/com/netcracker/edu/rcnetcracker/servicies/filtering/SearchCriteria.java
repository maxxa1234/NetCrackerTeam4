package com.netcracker.edu.rcnetcracker.servicies.filtering;

/*
* Class to create criteria for filtering
* key - field name
* value - parameter value
* */

public class SearchCriteria {

    private String key;
    private String value;

    public SearchCriteria(String key, String value) {
        super();
        this.key = key;
        this.value = value.substring(0, 1) + "'" + value.substring(1) + "'";
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

}
