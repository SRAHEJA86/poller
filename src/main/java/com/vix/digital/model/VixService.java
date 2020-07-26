package com.vix.digital.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VixService {
    public VixService(){

    }

    public VixService(String name, String serviceDescription){
        this.name = name;
        this.description = serviceDescription;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Id @GeneratedValue
    private int serviceId;

    private String name;
    private String description;
}
