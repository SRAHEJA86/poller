package com.vix.digital.service;

import com.sun.istack.internal.logging.Logger;
import com.vix.digital.model.ServiceInfo;
import com.vix.digital.repository.ServiceInfoRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class HttpPollerServiceTest {

    @Autowired
    ServiceInfoRepository serviceInfoRepository;

    @Value("${endpoint.url}")
    String url;

    @Test
    public void test_the_service_params() throws IOException {
        HttpPollerService poller = new HttpPollerService();
        ServiceInfo serviceInfo = poller.getServiceStatus(url);
        Assert.assertNotNull(serviceInfo);
        Assert.assertEquals(200,serviceInfo.getStatusCode());
        Assert.assertEquals("OK",serviceInfo.getMessage());
        long responseTimeThreshold = 20000000000000L;
        Assert.assertTrue(serviceInfo.getResponseTimeInMillis() < responseTimeThreshold);
    }

    @Test
    void test_add_service_information() {
        ServiceInfo serviceInfo = new ServiceInfo(200,"OK",120);
        ServiceInfo savedServiceInfo = serviceInfoRepository.save(serviceInfo);
        Assert.assertNotNull(savedServiceInfo);
    }

    @Test
    void test_when_error_in_service_response() throws IOException {
        HttpPollerService poller = Mockito.mock(HttpPollerService.class);
        Mockito.when(poller.getServiceStatus(url)).thenThrow(IOException.class);
        Logger logger = Logger.getLogger(HttpPollerService.class);

    }


}