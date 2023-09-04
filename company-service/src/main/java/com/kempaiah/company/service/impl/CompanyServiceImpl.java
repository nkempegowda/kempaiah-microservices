package com.kempaiah.company.service.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kempaiah.company.dto.CompanyDto;
import com.kempaiah.company.entity.Company;
import com.kempaiah.company.repository.CompanyRepository;
import com.kempaiah.company.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

  Logger LOGGER = LoggerFactory.getLogger(CompanyService.class);

  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private ModelMapper mapper;

  @Override
  public CompanyDto save(CompanyDto companyDto) {
    LOGGER.info("inside save Method");
    Company company = mapper.map(companyDto, Company.class);
    Company savedCompany = companyRepository.save(company);
    return mapper.map(savedCompany, CompanyDto.class);
  }

  @Override
  public CompanyDto getCompany(String code) {
    LOGGER.info("inside getCompany Method");
    Company company = companyRepository.findByCode(code);
    return mapper.map(company, CompanyDto.class);
  }
}
