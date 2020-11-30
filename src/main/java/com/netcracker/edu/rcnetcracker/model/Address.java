package com.netcracker.edu.rcnetcracker.model;

public class Address extends BaseEntity {
    private String flat;
    private Long buildingID;
    private Long utilityID;

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
