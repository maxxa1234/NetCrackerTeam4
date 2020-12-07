package com.netcracker.edu.rcnetcracker.servicies.filtering;

public class SortCriteria {

    private String property;
    private String direction;

    public SortCriteria(String property, String direction) {
        this.property = property;
        this.direction = direction;
    }

    public String getProperty() {
        return property;
    }

    public String getDirection() {
        return direction;
    }
}
