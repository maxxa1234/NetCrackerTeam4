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

    @Attribute(id = 10, clazz = User.class)
    protected User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User userId) {
        this.user = user;
    }
}
