package com.wkang.springboot.jpalearn.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;

@SpringBootApplication(scanBasePackages = {"com.wkang.springboot.jpalearn.demo"})
@EnableJpaRepositories(basePackages = "com.wkang.springboot.jpalearn.demo.dao")
@EntityScan(basePackages = "com.wkang.springboot.jpalearn.demo.pojo")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

