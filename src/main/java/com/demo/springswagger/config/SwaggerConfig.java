package com.demo.springswagger.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * Created by zer0, the Maverick Hunter
 * on 21/01/22
 * Class: SwaggerConfig
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.demo.springswagger.controller"))
                .paths(
                        Predicates.or(
                                PathSelectors.ant("/tutorial/**")
                        )
                )
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Demo API",
                "API Documentation with Spring and Swagger UI",
                "0.1",
                "https://github.com/guntutur",
                new Contact("zer0 the Maverick Hunter", "https://github.com/guntutur", ""),
                "LICENCE",
                "LICENCE URL",
                Collections.emptyList()
        );
    }

}
