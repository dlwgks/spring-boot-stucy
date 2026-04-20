package com.asdf.buddyboard.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiDocumentationConfig {
    @Bean
    public OpenAPI apiDocumentation(){
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Buddy Board API")
                                .version("1.0")
                                .description("추천인 기반의 BuddyBoard API 문서")
                );
    }
}
