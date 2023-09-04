package com.kempaiah.employeeservice.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.common.service.dto.EmployeeDTO;
import com.kempaiah.employeeservice.dao.EmployeeDAO;
import com.kempaiah.employeeservice.entity.Employee;
import com.kempaiah.employeeservice.repository.EmployeeRepository;
import com.kempaiah.employeeservice.service.feign.DepartmentClient;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

  @Autowired
  EmployeeRepository employeeRepository;

  @Autowired
  ModelMapper mapper;

  @Autowired
  private DepartmentClient departmentClient;

  @Override
  public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {

    Employee employee = mapper.map(employeeDTO, Employee.class);
    Employee savedEmployee = employeeRepository.save(employee);
    return mapper.map(savedEmployee, EmployeeDTO.class);
  }

  @Override
  public EmployeeDTO getEmployee(Long id) throws Exception {
    Employee employee = employeeRepository.findById(id).orElseThrow(() -> {
      return new Exception("Employee not found");
    });
    return mapper.map(employee, EmployeeDTO.class);
  }

  @Override
  public List<EmployeeDTO> getEmployees() throws Exception {
    List<EmployeeDTO> employeeDTOS = null;
    List<Employee> employees = employeeRepository.findAll();
    if(!CollectionUtils.isEmpty(employees)) {
      employeeDTOS = employees.stream()
          .map(employee -> mapper.map(employee, EmployeeDTO.class))
          .collect(Collectors.toList());

      if(!CollectionUtils.isEmpty(employeeDTOS))
      {
          employeeDTOS.stream().forEach( employeeDTO -> {
            if(null != employeeDTO.getDepartmentId())
            {
              employeeDTO.setDepartmentDTO(departmentClient.getDepartment(employeeDTO.getDepartmentId()));
            }
          });
      }
    }

    return employeeDTOS;
  }
}
