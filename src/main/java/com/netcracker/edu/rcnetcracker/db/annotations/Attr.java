package com.netcracker.edu.rcnetcracker.db.annotations;

public class Attr {
    public int id;
    public ValueType valueType;
    public Class<?> clazz;
    public String name;

    public Attr(int id, ValueType valueType, Class<?> clazz, String name) {
        this.id = id;
        this.valueType = valueType;
        this.clazz = clazz;
        this.name = name;
    }
}
