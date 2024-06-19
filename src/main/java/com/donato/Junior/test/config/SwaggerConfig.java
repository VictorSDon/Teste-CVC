package com.donato.Junior.test.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Teste CVC")
                        .description("projeto de teste CVC de recuperar e manipular dados do Github")
                        .version("v0.0.1")
                        );

    }
}
