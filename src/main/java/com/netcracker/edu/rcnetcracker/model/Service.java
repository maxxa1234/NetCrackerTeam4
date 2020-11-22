package com.netcracker.edu.rcnetcracker.model;

import java.util.UUID;

public class Service {
    private String serviceID;
    private String title;
    private Float tariff;

    public Service() {
    }

    public String getService_id() {
        return serviceID;
    }

    public void setService_id() {
        serviceID = UUID.randomUUID().toString();
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
