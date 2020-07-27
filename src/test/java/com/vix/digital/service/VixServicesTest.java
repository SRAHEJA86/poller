package com.vix.digital.service;

import com.vix.digital.model.VixService;
import com.vix.digital.repository.VixServiceRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class VixServicesTest {
    @Autowired
    VixServiceRepository vixServiceRepository;

    @Autowired
    VixService vixService;

    VixService savedVixService;

    @BeforeEach
    void addAService(){
        vixService = new VixService("NHS","Paediatric Services");
        savedVixService = vixServiceRepository.save(vixService);
    }

    @Test
    void getAllServices() {
        List<VixService> services = vixServiceRepository.findAll();
        Assert.assertTrue(services.size() > 0);

    }

    @Test
    void addService() {
        Assert.assertNotNull(savedVixService);
    }

    @Test
    void updateService() {
        String serviceName = "NHS111";
        vixService = new VixService("NHS111","Paediatric Services");
        vixServiceRepository.save(vixService);
        VixService serviceSaved = vixServiceRepository.findByName(serviceName);
        Assert.assertEquals(serviceName,serviceSaved.getName());
    }

    @Disabled("Id of the record not known")
    @Test
    void deleteService() throws Exception{
        int serviceId = 1;
        boolean serviceExistsBeforeDelete = vixServiceRepository.findById(serviceId).isPresent();
        vixServiceRepository.deleteById(serviceId);
        boolean serviceExistsAfterDelete =vixServiceRepository.findById(serviceId).isPresent();
        Assert.assertTrue(serviceExistsBeforeDelete);
        Assert.assertFalse(serviceExistsAfterDelete);
    }
}