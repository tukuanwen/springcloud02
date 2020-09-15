package com.tu.springboot005.dao.conf;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

//@Configuration
public class C3P0DataSourceConfiguration {

    @Value("${mysql.c3p0.driverClass}")
    private String driverClass;
    @Value("${mysql.c3p0.jdbcUrl}")
    private String jdbcUrl;
    @Value("${mysql.c3p0.user}")
    private String userName;
    @Value("${mysql.c3p0.password}")
    private String password;

    @Bean("C3P0DataSource")
    public DataSource getDataSource(){



        ComboPooledDataSource cpds = new ComboPooledDataSource();
        try {
            cpds.setDriverClass(driverClass); //loads the jdbc driver

            cpds.setJdbcUrl(jdbcUrl);
            cpds.setUser(userName);
            cpds.setPassword(password);
            cpds.setMinPoolSize(5);
            cpds.setAcquireIncrement(5);
            cpds.setMaxPoolSize(20);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return cpds;
    }

}
