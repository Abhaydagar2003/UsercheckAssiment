package com.UserChecker.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.tags.Tag;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swaggerconfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Getting Random Users and Store It")
                .description("API for the getting,storing,mailing users")
                .version("1.0.0")
                .contact(new Contact()
                    .name("Abhay Dagar")
                    .email("abhaydagar03@gmail.com")
                    .url("https://example.com"))
            )
//            .addServersItem(new Server().url("https://api.example.com").description("Production Server"))
//            .addServersItem(new Server().url("https://staging.example.com").description("Staging Server"))
            .addServersItem(new Server().url("http://localhost:8080").description("Local Development Server"))
            .components(new io.swagger.v3.oas.models.Components()
                .addSecuritySchemes("basicAuth", new SecurityScheme()
                    .type(SecurityScheme.Type.HTTP)
                    .scheme("basic")
                    .description("Basic Authentication"))
//                .addResponses("400", new ApiResponse().description("Bad Request"))
//                .addResponses("404", new ApiResponse().description("Not Found"))
//                .addResponses("500", new ApiResponse().description("Internal Server Error"))
            )
            .addSecurityItem(new SecurityRequirement().addList("basicAuth"))
            .addTagsItem(new Tag()
                .name("User API")
                .description("Endpoints related to user management"));
    }
}
