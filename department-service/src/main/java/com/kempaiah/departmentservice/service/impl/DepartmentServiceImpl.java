package com.kempaiah.departmentservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kempaiah.departmentservice.dao.DepartmentDAO;
import com.kempaiah.departmentservice.dto.DepartmentDTO;
import com.kempaiah.departmentservice.entity.Department;
import com.kempaiah.departmentservice.entity.Furniture;
import com.kempaiah.departmentservice.repository.DepartmentRepository;
import com.kempaiah.departmentservice.service.DepartmentService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class DepartmentServiceImpl implements DepartmentService {

  @Autowired
  private DepartmentRepository departmentRepository;

  @Autowired
  private DepartmentDAO departmentDAO;

  @PersistenceContext
  private EntityManager em;

  @Autowired
  private ModelMapper mapper;

  @Override
  @Transactional
  public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {

    Department departmentRequestEntity = mapper.map(departmentDTO, Department.class);
    if(null != departmentRequestEntity.getFurnitures())
    {
      List<Furniture> furnitures = departmentRequestEntity.getFurnitures();
      furnitures.stream().forEach(furniture -> {furniture.setDepartment(departmentRequestEntity);});
    }

    System.out.println("Department to be saved "+departmentRequestEntity);

    Department savedDepartmentEntity = em.merge(departmentRequestEntity);
    return mapper.map(savedDepartmentEntity, DepartmentDTO.class);
  }

  @Override
  public DepartmentDTO getDepartment(String departmentCode) {

    return departmentDAO.getDepartment(departmentCode);
  }
}
