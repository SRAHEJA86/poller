package com.vix.digital.controller;

import com.vix.digital.model.Services;
import com.vix.digital.model.VixService;
import com.vix.digital.service.VixServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceController {

    @Autowired
    VixServices vixServices;

    @Autowired
    Services services;

    @GetMapping("/services")
    public Services getAllServices(){
        List<VixService> serviceInfoList = vixServices.getAllServices();
        services.setServices(serviceInfoList);
        return services;
    }

    @PostMapping("/services")
    public void addService(@RequestBody VixService vixService){
        vixServices.addService(vixService);
    }

    @PutMapping("/services")
    public void updateService(@RequestBody VixService vixService){
        vixServices.updateService(vixService);
    }

    @DeleteMapping("/services")
    public void deleteService(@RequestBody VixService vixService){
        vixServices.deleteService(vixService);

    }
}
