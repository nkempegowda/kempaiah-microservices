package com.kempaiah.employeeservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@org.springframework.context.annotation.Configuration
public class Configuration {

  @Bean
  public ModelMapper getMapper(){
    return new ModelMapper();
  }

  @Bean
  public WebClient webClient()
  {
    return WebClient.builder().build();
  }

}
