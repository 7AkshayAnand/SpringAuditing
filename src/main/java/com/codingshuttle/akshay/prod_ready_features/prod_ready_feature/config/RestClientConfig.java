package com.codingshuttle.akshay.prod_ready_features.prod_ready_feature.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@Configuration
public class

RestClientConfig {

    @Value("${employeeService.base.url}")
    private String Base_Url;

    @Bean
    @Qualifier("employeeServiceRestClient")
    RestClient getEmployeeServiceRestClient(){
        return RestClient.builder().baseUrl(Base_Url)
                .defaultHeader(CONTENT_TYPE,APPLICATION_JSON_VALUE)
                .defaultStatusHandler(HttpStatusCode::is5xxServerError,((request, response) -> {
                    System.out.println("server error has been occoured");
                }))
                .build();
    }
}
