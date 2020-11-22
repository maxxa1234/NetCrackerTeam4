package com.netcracker.edu.rcnetcracker.model;

import java.util.UUID;

public class Adress {
    private String adressID;
    private String flat;
    private String buildingID;
    private String utilityID;

    public Adress() {
    }

    public String getAdressID() {
        return adressID;
    }

    public void setAdressID() {
        adressID = UUID.randomUUID().toString();
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(String buildingID) {
        this.buildingID = buildingID;
    }

    public String getUtilityID() {
        return utilityID;
    }

    public void setUtilityID(String utilityID) {
        this.utilityID = utilityID;
    }
}
