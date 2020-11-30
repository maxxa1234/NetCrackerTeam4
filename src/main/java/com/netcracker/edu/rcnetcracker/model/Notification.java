package com.netcracker.edu.rcnetcracker.model;

import com.netcracker.edu.rcnetcracker.db.annotations.Attribute;
import com.netcracker.edu.rcnetcracker.db.annotations.ObjectType;
import com.netcracker.edu.rcnetcracker.db.annotations.ValueType;
import java.util.Date;


@ObjectType(id = 13)
public class Notification extends BaseEntity {

    @Attribute(id = 32, valueType = ValueType.VALUE)
    private String text;

    @Attribute(id = 33, valueType = ValueType.DATE_VALUE)
    private Date date;

    @Attribute(id = 34, valueType = ValueType.VALUE)
    private String title;

    @Attribute(id = 35)
    private Long categoryId;

    @Attribute(id = 36)
    private Long createdBy;


}
