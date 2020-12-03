package com.netcracker.edu.rcnetcracker.model;

import com.netcracker.edu.rcnetcracker.db.annotations.Attribute;
import com.netcracker.edu.rcnetcracker.db.annotations.ObjectType;
import com.netcracker.edu.rcnetcracker.db.annotations.ValueType;

@ObjectType(id = 15)
public class Category extends BaseEntity {

    @Attribute(id = 44, valueType = ValueType.VALUE)
    private Boolean important;

    public Boolean getImportant() {
        return important;
    }

    public void setImportant(Boolean important) {
        this.important = important;
    }
}
