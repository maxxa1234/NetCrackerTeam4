package com.netcracker.edu.rcnetcracker.model;

import com.netcracker.edu.rcnetcracker.db.annotations.Attribute;
import com.netcracker.edu.rcnetcracker.db.annotations.ObjectType;
import com.netcracker.edu.rcnetcracker.db.annotations.ValueType;

@ObjectType(id = 3)
public class Ekey extends BaseEntity {

    @Attribute(id = 8, valueType = ValueType.VALUE)
    protected String keyCode;

    @Attribute(id = 9, valueType = ValueType.VALUE)
    protected Boolean isActive;

    @Attribute(id = 10)
    protected Long userId;

    public String getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(String keyCode) {
        this.keyCode = keyCode;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
