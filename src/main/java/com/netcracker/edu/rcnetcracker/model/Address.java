package com.netcracker.edu.rcnetcracker.model;

import com.netcracker.edu.rcnetcracker.db.annotations.Attribute;
import com.netcracker.edu.rcnetcracker.db.annotations.ObjectType;
import com.netcracker.edu.rcnetcracker.db.annotations.ValueType;

@ObjectType(id = 8)
public class Address extends BaseEntity {

    @Attribute(id = 17, valueType = ValueType.VALUE)
    private String flat;

    @Attribute(id = 16, clazz = Building.class)
    private Building building;

    @Attribute(id = 48, clazz = User.class)
    private User user;

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
