package com.kempaiah.employeeservice.service.feign;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.common.service.dto.DepartmentDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

//@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
@FeignClient(name = "${department-webservice}")
public interface DepartmentClient {


  //@Cacheable(value = "departments", key = "#departmentCode")
  @Retry(name = "${department-webservice}")
  @CircuitBreaker(name = "${department-webservice}", fallbackMethod = "getDepartment")

  @GetMapping("api/departments/{department-code}")
  public DepartmentDTO getDepartment(@PathVariable("department-code") String departmentCode);

  default DepartmentDTO getDepartment(String departmentCode, Throwable exception){
    DepartmentDTO departmentDTO = new DepartmentDTO(-1L,"-1","Invalid Product", "Invalid Product", null);
    return departmentDTO;
  }
}
