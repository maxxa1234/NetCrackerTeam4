package com.netcracker.edu.rcnetcracker.model;


public class Adress {
    private Long adressID;
    private String flat;
    private Long buildingID;
    private Long utilityID;

    public Adress() {
    }

    public Long getAdressID() {
        return adressID;
    }

    public void setAdressID(Long adressID) {
        this.adressID = adressID;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public Long getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(Long buildingID) {
        this.buildingID = buildingID;
    }

    public Long getUtilityID() {
        return utilityID;
    }

    public void setUtilityID(Long utilityID) {
        this.utilityID = utilityID;
    }
}
