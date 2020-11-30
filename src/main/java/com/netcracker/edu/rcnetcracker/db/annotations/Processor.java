package com.netcracker.edu.rcnetcracker.db.annotations;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Processor {
    public static int getObjtypeId(Class<?> clazz) {
            return clazz.getAnnotation(ObjectType.class).id();
    }

    public static Attr[] getAttributes(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        Attr[] attributes = new Attr[fields.length];
        for (int i = 0; i < fields.length; i++) {
            Attribute att = fields[i].getAnnotation(Attribute.class);
            attributes[i] = new Attr(att.id(), att.valueType(), fields[i].getType(), fields[i].getName());
        }

        return attributes;
    }
}
