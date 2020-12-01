package com.netcracker.edu.rcnetcracker.model;

import com.netcracker.edu.rcnetcracker.db.annotations.Attribute;
import com.netcracker.edu.rcnetcracker.db.annotations.ObjectType;
import com.netcracker.edu.rcnetcracker.db.annotations.ValueType;

import java.util.List;

@ObjectType(id = 2)
public class Entrance extends BaseEntity {

    @Attribute(id = 5)
    protected Long type_id;

    @Attribute(id = 7)
    protected Long building_id;

    @Attribute(id = 13, valueType = ValueType.LIST_VALUE)
    protected List<Long> roleId;

    @Attribute(id = 6, valueType = ValueType.VALUE)
    protected Boolean isActive;

    public List<Long> getRoleId() {
        return roleId;
    }

    public void setRoleId(List<Long> roleId) {
        this.roleId = roleId;
    }

    public Long getType_id() {
        return type_id;
    }

    public void setType_id(Long type_id) {
        this.type_id = type_id;
    }

    public Long getBuilding_id() {
        return building_id;
    }

    public void setBuilding_id(Long building_id) {
        this.building_id = building_id;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
