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
    private Integer lastMonthReading;

    @Attribute(id = 39, valueType = ValueType.VALUE)
    private Integer currentMonthReading;

    @Attribute(id = 40, valueType = ValueType.VALUE)
    private Float amountToPay;

    @Attribute(id = 41, valueType = ValueType.VALUE)
    private Boolean status;

    @Attribute(id = 42, valueType = ValueType.VALUE)
    private String photoURL;

    @Attribute(id = 43)
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

    public Float getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(Float amountToPay) {
        this.amountToPay = amountToPay;
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

    public Service getServiceID() {
        return service;
    }

    public void setServiceID(Service service) {
        this.service = service;
    }

    public Integer getLastMonthReading() {
        return lastMonthReading;
    }

    public void setLastMonthReading(Integer lastMonthReading) {
        this.lastMonthReading = lastMonthReading;
    }
}
