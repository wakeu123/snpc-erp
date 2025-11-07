package com.gaia.snpc_erp.config;

import org.springframework.web.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

import java.time.Duration;

@Configuration
public class RestClientConfig {

    @Value("${base-api.url}")
    private String baseApiUrl;

    @Value("${base-api.timeout.connect}")
    private int connectTimeout;

    @Value("${base-api.timeout.read}")
    private int readTimeout;

    @Bean
    public RestClient restClient() {
        return RestClient.builder()
                .baseUrl(baseApiUrl)
                .requestFactory(clientHttpRequestFactory())
                .defaultHeader("Content-Type", "application/json")
                .defaultHeader("Accept", "application/json")
                .build();
    }

    private ClientHttpRequestFactory clientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(Duration.ofMillis(connectTimeout));
        factory.setReadTimeout(Duration.ofMillis(readTimeout));
        return factory;
    }
}
