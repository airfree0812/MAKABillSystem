package com.maka.controller;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created with IntelliJ IDEA.
 * User: zdk
 * Date: 2019/09/24 14:53
 * Description: Swagger核心配置类
 * Version: V1.0
 */
@Configuration  //依赖Spring注解
@EnableSwagger2
public class SwaggerConfig {
    @Bean  //依赖Spring注解
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2) //使用2.0版本
                .enable(true)                           // 是否禁用swagger，可以控制全局。
                .useDefaultResponseMessages(false)     //是否使用默认响应消息方式
                .apiInfo(apiInfo())                    //创建API的基本信息，如：标题、描述、版本等
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger API文档")
                .description("测试接口文档")
                .version("1.0")
                .build();
    }
}
