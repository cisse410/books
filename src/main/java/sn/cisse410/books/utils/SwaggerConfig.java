package sn.cisse410.books.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info().title("API de gestion d'une librairie")
                .description("Ceci est un simple API CRUD pour la gestion des livres d'une librairie")
                .version("1.0.0"));
    }
}
