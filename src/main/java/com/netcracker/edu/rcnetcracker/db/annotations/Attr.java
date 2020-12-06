package com.netcracker.edu.rcnetcracker.db.annotations;

import java.lang.reflect.Field;

public class Attr {
    public Integer id;
    public ValueType valueType;
    public Field field;

    public Attr(Integer id, ValueType valueType, Field field) {
        this.id = id;
        this.valueType = valueType;
        this.field = field;
    }
}
