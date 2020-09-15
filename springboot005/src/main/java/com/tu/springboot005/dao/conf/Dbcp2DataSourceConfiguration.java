package com.tu.springboot005.dao.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//@Configuration
public class Dbcp2DataSourceConfiguration {

    @Bean("myDbcp2DataSource")
    @ConfigurationProperties(prefix = "mysql.dpcp2")
    public DataSource getDataSource(){
        return DataSourceBuilder.create().type(BasicDataSource.class).build();
    }

}
