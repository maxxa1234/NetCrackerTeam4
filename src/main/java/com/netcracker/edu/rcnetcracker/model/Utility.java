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

    public Long getServiceID() {
        return serviceID;
    }

    public void setServiceID(Long serviceID) {
        this.serviceID = serviceID;
    }
}
