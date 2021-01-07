package com.netcracker.edu.rcnetcracker.db.annotations;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.netcracker.edu.rcnetcracker.model.BaseEntity;
import org.springframework.core.annotation.AnnotationConfigurationException;

import javax.naming.directory.NoSuchAttributeException;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class Processor {
    public static int getObjtypeId(Class<? extends BaseEntity> clazz) {
        ObjectType ot = clazz.getAnnotation(ObjectType.class);
        if (ot == null) {

        }
        return ot.id();
    }

    public static ArrayList<Attr> getAttributes(Class<? extends BaseEntity> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        ArrayList<Attr> attributes = new  ArrayList<>();
        for (int i = 0; i < fields.length; i++) {
            Attribute att = fields[i].getAnnotation(Attribute.class);
            if (att != null) {
                attributes.add(new Attr(att.id(), att.valueType(), fields[i], att.clazz()));
            }
        }

        fields = clazz.getSuperclass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            attributes.add(new Attr(null, ValueType.BASE_VALUE, fields[i]));
        }

        return attributes;
    }

}
