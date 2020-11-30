package com.netcracker.edu.rcnetcracker.model;

import com.netcracker.edu.rcnetcracker.db.annotations.Attribute;
import com.netcracker.edu.rcnetcracker.db.annotations.ObjectType;
import com.netcracker.edu.rcnetcracker.db.annotations.ValueType;

import java.util.Date;

@ObjectType(id = 14)
public class Utility extends BaseEntity{

    @Attribute(id = 37, valueType = ValueType.VALUE)
    private String bankBook;

    @Attribute(id = 38, valueType = ValueType.DATE_VALUE)
    private Date date;

    @Attribute(id = 39, valueType = ValueType.VALUE)
    private Integer currentMonthReading;

    @Attribute(id = 40, valueType = ValueType.VALUE)
    private Float ammountToPay;

    @Attribute(id = 41, valueType = ValueType.VALUE)
    private Boolean status;

    @Attribute(id = 42, valueType = ValueType.VALUE)
    private String photoURL;

    @Attribute(id = 43)
    private Long serviceID;



}
