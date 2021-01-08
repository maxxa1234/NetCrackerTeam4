package com.netcracker.edu.rcnetcracker.model;

import com.netcracker.edu.rcnetcracker.db.annotations.Attribute;
import com.netcracker.edu.rcnetcracker.db.annotations.ObjectType;
import com.netcracker.edu.rcnetcracker.db.annotations.ValueType;

import java.util.List;

@ObjectType(id = 2)
public class Entrance extends BaseEntity {

    @Attribute(id = 5, clazz = Type.class)
    protected Type type;

    @Attribute(id = 7, clazz = Building.class)
    protected Building building;

    private RoleToEntrance roleToEntrance;
//    @Attribute(id = 13, valueType = ValueType.LIST_VALUE)
//    protected List<Long> roleId;

    @Attribute(id = 6, valueType = ValueType.VALUE)
    protected Boolean isActive;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public RoleToEntrance getRoleToEntrance() {
        return roleToEntrance;
    }

    public void setRoleToEntrance(RoleToEntrance roleToEntrance) {
        this.roleToEntrance = roleToEntrance;
    }

    //    public List<Long> getRoleId() {
//        return roleId;
//    }
//
//    public void setRoleId(List<Long> roleId) {
//        this.roleId = roleId;
//    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
