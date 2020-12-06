package com.netcracker.edu.rcnetcracker.model;

import com.netcracker.edu.rcnetcracker.db.annotations.Attribute;
import com.netcracker.edu.rcnetcracker.db.annotations.ObjectType;
import com.netcracker.edu.rcnetcracker.db.annotations.ValueType;

@ObjectType(id = 8)
public class Address extends BaseEntity {

    @Attribute(id = 17)
    private String flat;

    @Attribute(id = 16)
    private Long buildingID;

    @Attribute(id = 18)
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
