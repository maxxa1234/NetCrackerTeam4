package com.netcracker.edu.rcnetcracker.model;

import java.util.Date;

public class Utility {
    private Long utilityID;
    private String bankBook;
    private Date date;
    private Integer currentMonthReading;
    private Float ammountToPay;
    private boolean status;
    private String photoURL;
    private Long serviceID;

    public Utility() {
    }

    public Long getUtilityID() {
        return utilityID;
    }

    public void setUtilityID(Long utilityID) {
        this.utilityID = utilityID;
    }

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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
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
