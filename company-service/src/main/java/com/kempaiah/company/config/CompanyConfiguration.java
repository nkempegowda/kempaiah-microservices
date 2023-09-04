package com.kempaiah.company.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompanyConfiguration {

  @Bean
  public ModelMapper getMapper(){
    return new ModelMapper();
  }

}
