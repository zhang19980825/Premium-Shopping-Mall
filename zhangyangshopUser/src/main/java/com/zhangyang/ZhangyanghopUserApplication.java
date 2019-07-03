package com.zhangyang;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@EnableEurekaClient
@MapperScan("com.zhangyang.mapper")
//@ServletComponentScan(basePackages = "com.zhangyang.filter")
public class ZhangyanghopUserApplication {
    private static Logger logger = Logger.getLogger(ZhangyanghopUserApplication.class);

    /**
     * Start
     */
    public static void main(String[] args) {
        SpringApplication.run(ZhangyanghopUserApplication.class, args);
        logger.info("SpringBoot Start Success");
    }

}

