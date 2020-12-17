package com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria;

public class SortCriteria {

    private String property;
    private String direction;

    public SortCriteria(String property, String direction) {//
        this.property = property;
        this.direction = direction;
    }

    public SortCriteria(String sortParameters) {
        if (sortParameters != null){
            String params [] = sortParameters.split("\\:");
            property = params[0];
            direction = params[1];
        }
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
