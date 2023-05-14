package com.garageproject.gp;

import com.garageproject.gp.pojos.MailConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MailConfig.class)
public class GpApplication {

	public static void main(String[] args) {
		SpringApplication.run(GpApplication.class, args);
	}

}
