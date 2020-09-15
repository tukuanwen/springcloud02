package com.tu.springboot005.dao.conf;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.tu.springboot005.dao.mapper")
public class MybatisConfiguration {

    @Bean("sqlSessionFactory")
    public SqlSessionFactory masterSqlSessionFactory(DataSource dataSource) throws Exception {
        System.out.println("使用是那个数据源类型:"+dataSource.getClass());
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setVfs(SpringBootVFS.class); // Sets the SpringBootVFS class into SqlSessionFactoryBean
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:conf/mapper/*.xml"));
        factoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:conf/mybatisConfig.xml"));

//        factoryBean.setTransactionFactory( );
        return factoryBean.getObject();
    }

    @Bean
    public TransactionTemplate getTransaction(PlatformTransactionManager transactionManager){
        System.out.println("使用是那个事务类型:"+transactionManager.getClass());
        return new TransactionTemplate(transactionManager);
    }




}
