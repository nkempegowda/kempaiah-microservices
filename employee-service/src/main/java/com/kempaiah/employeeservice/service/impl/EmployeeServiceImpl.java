package com.kempaiah.employeeservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.common.service.dto.CompanyDto;
import com.common.service.dto.DepartmentDTO;
import com.common.service.dto.EmployeeDTO;
import com.kempaiah.employeeservice.dao.EmployeeDAO;
import com.kempaiah.employeeservice.repository.EmployeeRepository;
import com.kempaiah.employeeservice.service.EmployeeService;
import com.kempaiah.employeeservice.service.EmployeeServiceUtil;
import com.kempaiah.employeeservice.service.feign.DepartmentClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeDAO employeeDAO;

  @Autowired
  private WebClient webClient;

  @Autowired
  private DepartmentClient departmentClient;

  @Autowired
  private EmployeeServiceUtil employeeServiceUtil;


  @Override
  public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {

    return employeeDAO.saveEmployee(employeeDTO);
  }

  @Override
  @Retry(name = "${department-webservice}")
  @CircuitBreaker(name = "${department-webservice}", fallbackMethod = "getEmployee")
  public EmployeeDTO getEmployee(Long id) throws Exception {

    EmployeeDTO employeeDTO = employeeDAO.getEmployee(id);
    if(null != employeeDTO && null !=employeeDTO.getDepartmentId())
    {
      DepartmentDTO departmentDTO = (DepartmentDTO)
       webClient.get().uri("http://localhost:8080/api/departments/"+employeeDTO.getDepartmentId())
           .retrieve().bodyToMono(DepartmentDTO.class).block();
      System.out.println("101. "+departmentClient.getDepartment(employeeDTO.getDepartmentId()));
      employeeDTO.setDepartmentDTO(departmentDTO);
      employeeServiceUtil.populateCompany(employeeDTO);

    }

    return employeeDTO;
  }

  public EmployeeDTO getEmployee(Long id, Throwable exception) throws Exception {

    EmployeeDTO employeeDTO = employeeDAO.getEmployee(id);
    if(null != employeeDTO && null !=employeeDTO.getDepartmentId())
    {
      DepartmentDTO departmentDTO = new DepartmentDTO(-1L,"-1","Invalid Product", "Invalid Product", null);
      System.out.println("101. "+departmentClient.getDepartment(employeeDTO.getDepartmentId()));
      employeeDTO.setDepartmentDTO(departmentDTO);
    }
    employeeServiceUtil.populateCompany(employeeDTO);
    return employeeDTO;
  }


  @Override
  public List<EmployeeDTO> getEmployees() throws Exception {

    return employeeDAO.getEmployees();
  }
}
