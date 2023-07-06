package com.challenge.libro.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
    "com.challenge.ecomerce.controller",
    "com.challenge.ecomerce.service",
    "com.challenge.ecomerce.repository"
})

public class AppConfig {

}
