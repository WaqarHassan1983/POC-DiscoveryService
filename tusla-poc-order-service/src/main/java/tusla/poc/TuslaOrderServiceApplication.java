package tusla.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class TuslaOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TuslaOrderServiceApplication.class, args);
	}
}
