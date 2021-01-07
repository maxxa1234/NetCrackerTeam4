package com.netcracker.edu.rcnetcracker.model;

import com.netcracker.edu.rcnetcracker.db.annotations.Attribute;
import com.netcracker.edu.rcnetcracker.db.annotations.ObjectType;
import com.netcracker.edu.rcnetcracker.db.annotations.ValueType;

@ObjectType(id = 8)
public class Address extends BaseEntity {

    @Attribute(id = 17)
    private String flat;

    @Attribute(id = 16)
    private Building building;

    @Attribute(id = 18)
    private Utility utility;

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public Building getBuildingID() {
        return building;
    }

    public void setBuildingID(Building building) {
        this.building = building;
    }

    public Utility getUtilityID() {
        return utility;
    }

    public void setUtilityID(Utility utility) {
        this.utility = utility;
    }
}
