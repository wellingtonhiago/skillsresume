package com.skillsresume.curriculum.config

import org.springframework.context.annotation.Configuration
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.context.annotation.Bean

@Configuration
class OpenApiConfig {
    @Bean
    fun customOpenApi(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("RESTFul Api with kotlin 1.7.22 and Spring Boot 3.0.1")
                    .version("v1")
                    .description("Projeto protótipo do currículo inteligente")
                    .termsOfService("https://github.com/joosecj/skillsresume")
                    .license(
                        License().name("Apache 2.0")
                            .url("https://github.com/joosecj/skillsresume")
                    )
            )
    }
}