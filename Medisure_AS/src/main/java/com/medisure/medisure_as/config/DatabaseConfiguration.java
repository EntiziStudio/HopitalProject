package com.medisure.medisure_as.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"com.medisure.medisure_as.repository"})
@EnableTransactionManagement
public class DatabaseConfiguration {
}
