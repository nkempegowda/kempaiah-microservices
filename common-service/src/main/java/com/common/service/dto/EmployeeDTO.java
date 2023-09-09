package com.common.service.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {


  private Long id;

  private String firstName;

  private String lastName;

  private String email;

  private String departmentId;

  private String companyCode;

}
