package com.vix.digital.model;

import java.util.List;

public class Services {
    public List<VixService> getServices() {
        return services;
    }

    public void setServices(List<VixService> services) {
        this.services = services;
    }

    List<VixService> services;
}
