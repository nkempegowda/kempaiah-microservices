package com.kempaiah.departmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FurnitureDTO {

  private Long id;
  private String code;
  private String type;
  private String lable;
}
