package com.kempaiah.employeeservice.service.impl;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.common.service.dto.CompanyDto;
import com.common.service.dto.EmployeeDTO;
import com.kempaiah.employeeservice.service.EmployeeServiceUtil;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class EmployeeServiceUtilImpl implements EmployeeServiceUtil {
  Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceUtilImpl.class);

  @Autowired
  private WebClient webClient;

  @Retry(name = "${company-webservice}")
  @CircuitBreaker(name = "${company-webservice}", fallbackMethod = "populateCompany")
  public void populateCompany(EmployeeDTO employeeDTO) {
    LOGGER.info("populating company");
    if(StringUtils.isNotEmpty(employeeDTO.getCompanyCode()))
    {
      CompanyDto companyDto = (CompanyDto)
          webClient.get().uri("http://localhost:9001/api/companies/"+employeeDTO.getCompanyCode())
              .retrieve().bodyToMono(CompanyDto.class).block();
      employeeDTO.setCompanyDTO(companyDto);
    }

  }

  public void populateCompany(EmployeeDTO employeeDTO, Throwable exception) throws Exception {
    LOGGER.info("populating company fall back method");

    if(null != employeeDTO && StringUtils.isNotEmpty(employeeDTO.getCompanyCode()))
    {
      CompanyDto companyDto = new CompanyDto(-1L,"Invalid Company","Invalid Company", "-1");
      employeeDTO.setCompanyDTO(companyDto);
    }

  }
}
