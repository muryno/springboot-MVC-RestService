package com.example.demo.configuration;


import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistConfiguration {

    @Bean
    public DataSource getDataSource(){
        var myDataSource =  DataSourceBuilder.create();
        myDataSource.url("jdbc:postgresql://localhost:5432/conference-demo")
                .username("postgres")
                .password("");
        ;

        System.out.println("My custom data source has been created");
      return   myDataSource.build();
    }
}
