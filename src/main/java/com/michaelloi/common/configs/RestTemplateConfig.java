package com.michaelloi.common.configs;

import com.michaelloi.common.constants.ConfigValues;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class RestTemplateConfig {

    @Value(ConfigValues.timeout.restTemplate)
    long timeout;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplateBuilder()
            .setConnectTimeout(Duration.ofMillis(timeout))
            .setReadTimeout(Duration.ofMillis(timeout))
            .build();
    }
}
