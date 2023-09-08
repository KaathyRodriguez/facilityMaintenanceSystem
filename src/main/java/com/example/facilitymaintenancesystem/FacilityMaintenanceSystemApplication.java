package com.example.facilitymaintenancesystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class FacilityMaintenanceSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(FacilityMaintenanceSystemApplication.class, args);
    }

}
