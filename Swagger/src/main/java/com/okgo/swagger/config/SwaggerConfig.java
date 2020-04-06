package com.okgo.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.RequestHandlerProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author Shawn
 * @date 2020/4/5 0:27
 * @title Function
 */
@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {

    @Bean
    public Docket docketAgroup() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }

    @Bean
    public Docket docketBgroup() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }

    @Bean
    public Docket docketCgroup() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }


    @Bean
    public Docket docket(Environment env) {
        // 设置swagger显示的环境, 默认的.properties文件不能显示
        Profiles profiles = Profiles.of("dev", "test");
        // 通过.acceptsProfiles()判断是否处在自己设定的环境中
        boolean flag = env.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(this.apiInfo())
                // .enable 是否启动swagger, false 不启动
                .enable(true)
                .groupName("Default")
                .select()
                // RequestHandlerSelectors配置要扫描接口的方式，basePackage指定要扫描包的路径
                // .any(): 扫描全部; .none()：不扫描; .withClassAnnotation：扫描类上的注解，参数是一个注解的反射对象
                .apis(RequestHandlerSelectors.basePackage("com.okgo.swagger.controller"))
                // .paths过滤路径
                .paths(PathSelectors.ant("/swagger/**"))
                .build();

    }

    private ApiInfo apiInfo() {
        // 作者信息
        Contact contact = new Contact("Shawn", "okgo.com", "enjoycode10@gmail.com");
        return new ApiInfo("Swagger2 Api Documentation Study",
                "Api Documentation Description",
                "1.0.8",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
