package com.vix.digital.service;

import com.vix.digital.model.VixService;
import com.vix.digital.repository.VixServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VixServices {

    @Autowired
    VixServiceRepository vixServiceRepository;

    /**
     *Returns the list of all services
     * @return List of VixServices
     */
    public List<VixService> getAllServices() {
        return vixServiceRepository.findAll();
    }

    /**
     *Adds a service to the database
     * @param vixService Service
     */
    public void addService(VixService vixService) {
        vixServiceRepository.save(vixService);
    }

    /**
     *Updates a service
     * @param vixService Service
     */
    public void updateService(VixService vixService) {
        vixServiceRepository.save(vixService);
    }

    /**
     *Deletes a service
     * @param vixService Service
     */
    public void deleteService(VixService vixService) {
        vixServiceRepository.delete(vixService);
    }
}
