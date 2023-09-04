package com.kempaiah.departmentservice.dto;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Assert;

import com.kempaiah.departmentservice.entity.Department;

public class MapperTest {

  private ModelMapper mapper;

  @BeforeEach
  public void setup() {
    this.mapper = new ModelMapper();
  }

  @Test
  public void testMapper() {

      DepartmentDTO departmentDTO = new DepartmentDTO();
      departmentDTO.setId(1L);
      departmentDTO.setName("Mechanical Department");
      departmentDTO.setCode("DT001");
      departmentDTO.setDescription("Department Of Mechanical Engineering");

      FurnitureDTO furnitureDTO = new FurnitureDTO();
      furnitureDTO.setCode("F001");
      furnitureDTO.setId(1L);
      furnitureDTO.setType("WOOD");
      furnitureDTO.setLable("Godrej");

      departmentDTO.setFurnitures(List.of(furnitureDTO));

    Assert.notNull(mapper.map(departmentDTO, Department.class),"Department cannot be null");

    return;
  }
}
