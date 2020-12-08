package com.netcracker.edu.rcnetcracker.servicies.criteria;

public class SortCriteria {

    private String property;
    private String direction;

    public SortCriteria(String property, String direction) {
        this.property = property;
        this.direction = direction;
    }

    public SortCriteria() {
    }

    public String getProperty() {
        return property;
    }

    public String getDirection() {
        return direction;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

}
