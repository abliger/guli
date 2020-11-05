package com.atguigu.guli.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author abliger
 */

@SpringBootApplication
@EnableDiscoveryClient
public class GateWayApplication {
    public static void main(String[] args) {
            SpringApplication.run(GateWayApplication.class,args);
    }

}
