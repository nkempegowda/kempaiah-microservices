package com.kempaiah.departmentservice.dao;

import com.kempaiah.departmentservice.dto.DepartmentDTO;

public interface DepartmentDAO {
  DepartmentDTO getDepartment(String departmentCode);
}
