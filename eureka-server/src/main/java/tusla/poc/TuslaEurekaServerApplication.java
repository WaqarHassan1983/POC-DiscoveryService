package tusla.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class TuslaEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TuslaEurekaServerApplication.class, args);
	}
}
