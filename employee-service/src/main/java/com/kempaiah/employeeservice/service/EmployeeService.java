package com.kempaiah.employeeservice.service;

import java.util.List;

import com.common.service.dto.CompanyDto;
import com.common.service.dto.EmployeeDTO;

public interface EmployeeService {
  EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

  EmployeeDTO getEmployee(Long id) throws Exception;

  List<EmployeeDTO> getEmployees() throws Exception;

}
