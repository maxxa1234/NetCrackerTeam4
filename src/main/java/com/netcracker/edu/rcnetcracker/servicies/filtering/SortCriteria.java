package com.netcracker.edu.rcnetcracker.servicies.filtering;

public class SortCriteria {

    private String property;
    private String direction;
    private String page;
    private String size;

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

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
