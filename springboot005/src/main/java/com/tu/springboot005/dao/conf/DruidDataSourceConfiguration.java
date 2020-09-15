package com.tu.springboot005.dao.conf;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.config.JtaTransactionManagerFactoryBean;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;

//@Configuration
public class DruidDataSourceConfiguration {

    @Value("${mysql.druid.driverClass}")
    private String driverClass;
    @Value("${mysql.druid.jdbcUrl}")
    private String jdbcUrl;
    @Value("${mysql.druid.user}")
    private String userName;
    @Value("${mysql.druid.password}")
    private String password;

    @Bean(value = "druidDataSource")
    public DataSource getDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClass);
        druidDataSource.setUrl(jdbcUrl);
        druidDataSource.setUsername(userName);
        druidDataSource.setPassword(password);
        druidDataSource.setDefaultTransactionIsolation(1);
        return druidDataSource;
    }

    /**
     * 标准的事务管理
     * @param dataSource
     * @return
     */
    @Bean
    public TransactionManager transactionManager(@Qualifier("druidDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 容器的事务管理
     * @return
     */
    @Bean
    public JtaTransactionManager transactionManager() {
        return new JtaTransactionManagerFactoryBean().getObject();
    }



}
