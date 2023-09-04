package com.kempaiah.departmentservice.service;

import com.kempaiah.departmentservice.dto.DepartmentDTO;

public interface DepartmentService {

  DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);

  DepartmentDTO getDepartment(String departmentCode);
}
