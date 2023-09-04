package com.kempaiah.employeeservice.dao;

import java.util.List;

import com.common.service.dto.EmployeeDTO;

public interface EmployeeDAO {

  EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

  EmployeeDTO getEmployee(Long id) throws Exception;

  List<EmployeeDTO> getEmployees() throws Exception;

}
