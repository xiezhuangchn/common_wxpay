package com.hnair.pay.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 订单自增id生成
 */
@Configuration
public class DataSourceConfig {

    @Value("${hotel_order.jdbcUrl}")
    private String jdbcUrl;

    @Value("${hotel_order_rw.user}")
    private String user;

    @Value("${hotel_order_rw.pass}")
    private String pwd;

    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setInitialSize(10);
        dataSource.setMaxActive (100);
        dataSource.setMaxIdle (50);
        dataSource.setMinIdle (10);
        dataSource.setLogAbandoned (true);
        dataSource.setRemoveAbandoned  (true);
        dataSource.setRemoveAbandonedTimeout(180);
        dataSource.setMaxWait(300);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(true);
        dataSource.setTestWhileIdle(true);
        dataSource.setTimeBetweenEvictionRunsMillis(8500);
        dataSource.setMinEvictableIdleTimeMillis(9500);
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(user);
        dataSource.setPassword(pwd);
        return dataSource;
    }
}
