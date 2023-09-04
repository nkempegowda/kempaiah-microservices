package com.kempaiah.company.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kempaiah.company.dto.CompanyDto;
import com.kempaiah.company.service.CompanyService;

@RestController
@RequestMapping("api/companies")
public class CompanyController {

  Logger LOGGER = LoggerFactory.getLogger(CompanyController.class);

  @Autowired
  private CompanyService companyService;

  @PostMapping
  public ResponseEntity<CompanyDto> createCompany(@RequestBody CompanyDto companyDto)
  {
    LOGGER.info("inside createCompany Method");
    CompanyDto savedCompany = companyService.save(companyDto);
    return ResponseEntity.ok(savedCompany);
  }

  @GetMapping("{code}")
  public ResponseEntity<CompanyDto> getCompany(@PathVariable String code)
  {
    LOGGER.info("inside getCompany Method");
    CompanyDto company = companyService.getCompany(code);
    return ResponseEntity.ok(company);
  }
}
