package com.vix.digital;

import com.vix.digital.model.ServiceInfo;
import com.vix.digital.model.Services;
import com.vix.digital.model.VixService;
import com.vix.digital.service.HttpPollerService;
import com.vix.digital.service.VixServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@Configuration
public class VixDigitalApplication {


	public static void main(String[] args) {
		SpringApplication.run(VixDigitalApplication.class, args);
		HttpPollerService poller = new HttpPollerService();
		ScheduledExecutorService schedular = Executors.newScheduledThreadPool(1);
		//specify the time duration
		schedular.scheduleAtFixedRate(poller, 0,10, TimeUnit.MINUTES);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public ServiceInfo getServiceInfo(){
		return new ServiceInfo();
	}


	@Bean
	public VixService getVixService(){
		return new VixService();
	}

	@Bean
	public VixServices getVixServices() { return new VixServices();	}

	@Bean
	public Services getServices(){
		return new Services();
	}

}
