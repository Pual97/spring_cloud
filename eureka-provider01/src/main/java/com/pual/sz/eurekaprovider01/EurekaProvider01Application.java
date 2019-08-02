package com.pual.sz.eurekaprovider01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@EnableDiscoveryClient
@SpringBootApplication
public class EurekaProvider01Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProvider01Application.class, args);
    }

}
