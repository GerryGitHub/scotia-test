package com.example.test.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    RestClient petStoreClient(
            RestClient.Builder builder,
            @Value("${petstore.base-url}") String petUrl
    ) {
        return builder
                .baseUrl(petUrl)
                .build();
    }

}
