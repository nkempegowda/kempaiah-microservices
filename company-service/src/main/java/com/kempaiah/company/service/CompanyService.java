package com.kempaiah.company.service;

import com.kempaiah.company.dto.CompanyDto;

public interface CompanyService {

  CompanyDto save(CompanyDto companyDto);

  CompanyDto getCompany(String code);
}
