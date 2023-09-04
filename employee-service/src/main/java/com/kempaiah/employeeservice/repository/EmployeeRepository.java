package com.kempaiah.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kempaiah.employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
