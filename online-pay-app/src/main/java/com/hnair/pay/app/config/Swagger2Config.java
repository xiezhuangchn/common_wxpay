package com.hnair.pay.app.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration //spring boot配置注解
@EnableSwagger2 //启用swagger2功能注解
@ConditionalOnProperty(name = "swagger.enable", havingValue = "true")
public class Swagger2Config {

    @Bean
    public Docket swaggerSpringMvcPlugin() {
        ApiInfo apiInfo = new ApiInfo("SuperMock",
                "支付平台",
                "1.0",
                "",
                new Contact("online-pay", "@hnair.com", "@hnair.com"),
                "",
                "",
                Collections.<VendorExtension>emptyList());
        return new Docket(DocumentationType.SWAGGER_2).groupName("onlinePay")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hnair.pay.app.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo);
    }

}
