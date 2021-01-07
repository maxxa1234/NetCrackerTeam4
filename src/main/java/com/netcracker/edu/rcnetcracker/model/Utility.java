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

    @Attribute(id = 47 ,valueType = ValueType.VALUE)
    private Integer lastMonthReadings;

    @Attribute(id = 39, valueType = ValueType.VALUE)
    private Integer currentMonthReading;

    @Attribute(id = 40, valueType = ValueType.VALUE)
    private Float ammountToPay;

    @Attribute(id = 41, valueType = ValueType.VALUE)
    private Boolean status;

    @Attribute(id = 42, valueType = ValueType.VALUE)
    private String photoURL;

    @Attribute(id = 43, clazz = Service.class)
    private Service service;

    public String getBankBook() {
        return bankBook;
    }

    public void setBankBook(String bankBook) {
        this.bankBook = bankBook;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCurrentMonthReading() {
        return currentMonthReading;
    }

    public void setCurrentMonthReading(Integer currentMonthReading) {
        this.currentMonthReading = currentMonthReading;
    }

    public Float getAmmountToPay() {
        return ammountToPay;
    }

    public void setAmmountToPay(Float ammountToPay) {
        this.ammountToPay = ammountToPay;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Integer getLastMonthReadings() {
        return lastMonthReadings;
    }

    public void setLastMonthReadings(Integer lastMonthReadings) {
        this.lastMonthReadings = lastMonthReadings;
    }
}
