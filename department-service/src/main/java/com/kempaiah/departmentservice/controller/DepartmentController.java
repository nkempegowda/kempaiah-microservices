package com.kempaiah.departmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kempaiah.departmentservice.dto.DepartmentDTO;
import com.kempaiah.departmentservice.service.DepartmentService;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {

  @Autowired
  private DepartmentService departmentService;

  @PostMapping
  public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO) {
    DepartmentDTO savedDepartment = departmentService.saveDepartment(departmentDTO);
    return ResponseEntity.ok(savedDepartment);
  }

  @GetMapping("{department-code}")
  public ResponseEntity<DepartmentDTO> saveDepartment(@PathVariable("department-code") String departmentCode) {
    DepartmentDTO savedDepartment = departmentService.getDepartment(departmentCode);
    return ResponseEntity.ok(savedDepartment);
  }
}
