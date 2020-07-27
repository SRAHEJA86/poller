package com.vix.digital.service;

import java.io.IOException;

import com.vix.digital.model.ServiceInfo;
import com.vix.digital.repository.ServiceInfoRepository;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@ConfigurationProperties(prefix="endpoint")
@Service
public class HttpPollerService implements Runnable{

    @Autowired
    ServiceInfo serviceInfo;

    @Autowired
    ServiceInfoRepository serviceInfoRepository;

    OkHttpClient client = new OkHttpClient();

    @Value("${endpoint.url}")
    String url ;

    private static final Logger log = LoggerFactory.getLogger(HttpPollerService.class);

    /**
     * Use OKHttp to send GET API poll request
     */
    public ServiceInfo getServiceStatus(String url) throws IOException {
            Request request = new Request.Builder().url(url).build();
            Response response = client.newCall(request).execute();
            serviceInfo = new ServiceInfo(response.code(),
                        response.message(),response.receivedResponseAtMillis());
            return serviceInfo;
    }

    /**
     * Persists the service status information to the database
     */
    public void saveServiceStatusInfo(ServiceInfo serviceInfo){
        serviceInfoRepository.save(serviceInfo);
    }

    /**
     * This method gets called after every specified duration
     */
    @Override
    public void run() {
        try {
            ServiceInfo serviceInfo = this.getServiceStatus(url);
            this.saveServiceStatusInfo(serviceInfo);
            if(serviceInfo.getResponseTimeInMillis() > 200)
                log.warn("The service is taking too long to respond");

            if(serviceInfo.getStatusCode()!=200)
                log.warn("The service did not respond OK");


        } catch (IOException e) {
            log.error("Error while accessing the service" ,e);
        }
    }

}
