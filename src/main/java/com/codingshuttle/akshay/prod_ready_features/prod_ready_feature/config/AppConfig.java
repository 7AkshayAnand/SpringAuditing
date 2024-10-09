package com.codingshuttle.akshay.prod_ready_features.prod_ready_feature.config;

import com.codingshuttle.akshay.prod_ready_features.prod_ready_feature.auth.AuditorAwareImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "getAuditorImpl")
public class AppConfig {
    @Bean
    ModelMapper getModelMapper(){
        return new ModelMapper();
    }
    @Bean
    AuditorAware<String> getAuditorImpl(){
        return new AuditorAwareImpl();
    }
}
