package com.example.ppctrl.config;

import com.example.ppctrl.application.ExecuteActionUseCase;
import com.example.ppctrl.domain.ProductOperator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PPCtrlBeanConfig {

    @Bean
    ExecuteActionUseCase executeActionUseCase(ProductOperator productOperator) {
        return new ExecuteActionUseCase(productOperator);
    }
}
