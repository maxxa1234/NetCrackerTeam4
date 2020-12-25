package com.netcracker.edu.rcnetcracker.model;

import com.netcracker.edu.rcnetcracker.db.annotations.Attribute;
import com.netcracker.edu.rcnetcracker.db.annotations.ObjectType;
import com.netcracker.edu.rcnetcracker.db.annotations.ValueType;

import java.util.List;

@ObjectType(id = 2)
public class Entrance extends BaseEntity {

    @Attribute(id = 5)
    protected Long typeId;

    @Attribute(id = 7)
    protected Long buildingId;

    private RoleToEntrance roleToEntrance;
//    @Attribute(id = 13, valueType = ValueType.LIST_VALUE)
//    protected List<Long> roleId;

    @Attribute(id = 6, valueType = ValueType.VALUE)
    protected Boolean isActive;

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
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
