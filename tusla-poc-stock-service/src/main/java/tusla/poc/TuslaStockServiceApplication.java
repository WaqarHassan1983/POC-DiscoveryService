package tusla.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class TuslaStockServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TuslaStockServiceApplication.class, args);
	}
}
