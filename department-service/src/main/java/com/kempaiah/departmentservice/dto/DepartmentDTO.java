package com.kempaiah.departmentservice.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

  private Long id;

  private String code;

  private String name;

  private String description;

  List<FurnitureDTO> furnitures;
}
