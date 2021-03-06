package com.pual.sz.eurekaprovider02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaProvider02Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProvider02Application.class, args);
    }

}
