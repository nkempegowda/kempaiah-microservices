package com.kempaiah.departmentservice.dao.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kempaiah.departmentservice.dao.DepartmentDAO;
import com.kempaiah.departmentservice.dto.DepartmentDTO;
import com.kempaiah.departmentservice.entity.Department;
import com.kempaiah.departmentservice.repository.DepartmentRepository;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

  @Autowired
  private DepartmentRepository departmentRepository;

  @Autowired
  private ModelMapper mapper;

  @Override
  public DepartmentDTO getDepartment(String departmentCode) {
    DepartmentDTO departmentDTO = null;
    Optional<Department> optionalDepartment = departmentRepository.findDepartmentByCode(departmentCode);
    if(optionalDepartment.isPresent())
    {
      departmentDTO = mapper.map(optionalDepartment.get(), DepartmentDTO.class);
    }
    return departmentDTO;
  }
}
