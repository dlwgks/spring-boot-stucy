package com.mysite.exam1.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI minilogOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Minilog API 명세서")
                        .description("추천인 및 차단 기능이 포함된 미니로그 프로젝트 API입니다.")
                        .version("v1.0.0"));
    }
}