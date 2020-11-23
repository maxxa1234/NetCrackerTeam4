package com.netcracker.edu.rcnetcracker.model;


public class Service {
    private Long serviceID;
    private String title;
    private Float tariff;

    public Service() {
    }

    public Long getService_id() {
        return serviceID;
    }

    public void setService_id(Long serviceID) {
        this.serviceID = serviceID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getTariff() {
        return tariff;
    }

    public void setTariff(Float tariff) {
        this.tariff = tariff;
    }
}
