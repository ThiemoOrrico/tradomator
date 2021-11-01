package com.tradomator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class TradomatorBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(TradomatorBackendApplication.class, args);
        }

    @Bean
    public WebClient localApiClient() {
        return WebClient.create("https://api.coingecko.com/api/v3/");
    }


}
