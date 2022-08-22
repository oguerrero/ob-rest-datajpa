package com.oguerrero.obrestdatajpa.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Configuración de Swagger para la generacion de documentacion de la API REST
 * 
 * http://localhost:8080/swagger-ui
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfo("Spring Boot Books API REST", "Library API REST docs", "1.0",
                        "http://www.google.com",
                        new Contact("Oscar", "https://www.github.io", "oscarguerrero242@gmai.com"), "MIT",
                        "http://www.google.com", Collections.emptyList()))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
