package com.atguigu.guli.service.edu;

import com.alibaba.csp.sentinel.transport.config.TransportConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Description:
 *
 * @author abliger
 */
@SpringBootApplication
//修改主程序扫描的默认包
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan(basePackages = "com.atguigu.guli.service")
@MapperScan("com.atguigu.guli.service.edu.mapper")
public class ServiceEduApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceEduApplication.class,args);
    }
}
