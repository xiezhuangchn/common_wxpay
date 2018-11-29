package com.hnair.pay.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfigurer  extends WebMvcConfigurerAdapter {

    @Bean
    public OrdserLogInterceptor getOrdserLogInterceptor() {
        return new OrdserLogInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getOrdserLogInterceptor());
        super.addInterceptors(registry);
    }

}

