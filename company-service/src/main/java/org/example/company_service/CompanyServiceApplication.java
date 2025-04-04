package org.example.company_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaServer
@EnableFeignClients
@SpringBootApplication
public class CompanyServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CompanyServiceApplication.class, args);
  }

}
