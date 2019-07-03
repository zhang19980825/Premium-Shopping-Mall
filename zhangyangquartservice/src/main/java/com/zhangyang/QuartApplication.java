package com.zhangyang;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@EnableEurekaClient
@MapperScan("com.zhangyang.mapper")
@EnableDiscoveryClient
@EnableFeignClients
public class QuartApplication {
    private static Logger logger = Logger.getLogger(QuartApplication.class);

    /**
     * Start
     */
    public static void main(String[] args) {
        SpringApplication.run(QuartApplication.class, args);
        logger.info("SpringBoot Start Success");
    }

}
