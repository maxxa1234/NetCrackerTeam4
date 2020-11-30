package com.netcracker.edu.rcnetcracker.model;

import com.netcracker.edu.rcnetcracker.db.annotations.Attribute;
import com.netcracker.edu.rcnetcracker.db.annotations.ObjectType;
import com.netcracker.edu.rcnetcracker.db.annotations.ValueType;

@ObjectType(id = 16)
public class Service extends BaseEntity {

    @Attribute(id = 45, valueType = ValueType.VALUE)
    private String title;

    @Attribute(id = 46, valueType = ValueType.VALUE)
    private Float tariff;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getTariff() {
        return tariff;
    }

    public void setTariff(Float tariff) {
        this.tariff = tariff;
    }
}
