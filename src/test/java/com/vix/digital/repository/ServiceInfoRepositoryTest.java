package com.vix.digital.repository;

import com.vix.digital.model.ServiceInfo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

class ServiceInfoRepositoryTest {

    @Autowired
    ServiceInfo serviceInfo;

    @Autowired
    ServiceInfoRepository serviceInfoRepository;

    @Test
    void test_add_service_information() {
        ServiceInfo serviceInfo = new ServiceInfo(200,"OK",120);
        ServiceInfo savedServiceInfo = serviceInfoRepository.save(serviceInfo);
        Assert.assertNotNull(savedServiceInfo);
    }


}