package com.pk;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Created by pangkunkun on 2018/5/30.
 */
@SpringBootApplication
public class JooqStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(JooqStudyApplication.class,args);
    }


    @Value("${spring.datasource.url:jdbc:mysql://localhost:3306/}")
    private String dbUrl;
    @Value("${spring.datasource.username:root}")
    private String username;
    @Value("${spring.datasource.password:root}")
    private String password;
    @Value("${spring.datasource.hikari.maximum-pool-size:10}")
    private int maxPoolSize;

    @Bean
    public JooqClient jooqClient() throws Exception{
        return new JooqClient(dbUrl,username,password,maxPoolSize);
    }

}
