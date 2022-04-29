package com.sky.operationintercept.config;

import com.sky.operationintercept.handler.OperationHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sk on 2022/4/28
 */
@Configuration
@ComponentScan(value = "com.sky.operationintercept.handler")
public class OperationAutoConfiguration {

    @Bean
    public OperationHandler operationHandler() {
        return new OperationHandler();
    }

    @Bean
    @ConditionalOnMissingBean(OperationBehave.class)
    public OperationBehave operationBehave(){
        return new OperationBehave();
    }
}
