package com.kempaiah.departmentservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kempaiah.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

  Optional<Department> findDepartmentByCode(String code);

}
