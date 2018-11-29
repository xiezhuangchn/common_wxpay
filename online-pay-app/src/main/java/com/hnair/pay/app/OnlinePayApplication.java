package com.hnair.pay.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan({"com.hnair.pay","com.pay.task","com.hnair.pay.agent.weixin.service.impl"})
@MapperScan(basePackages = {"com.hnair.pay.db.dao.mapper", "com.hnair.pay.db.dao.mapext"})
@EnableAutoConfiguration
public class OnlinePayApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(OnlinePayApplication.class);
	}
	
}
