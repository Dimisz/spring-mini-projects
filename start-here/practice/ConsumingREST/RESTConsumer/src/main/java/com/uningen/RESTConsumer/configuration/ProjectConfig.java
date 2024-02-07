package com.uningen.RESTConsumer.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.uningen.RESTConsumer.proxy")
public class ProjectConfig {
}
