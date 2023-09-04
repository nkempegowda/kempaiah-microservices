package com.kempaiah.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kempaiah.company.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

  Company findByCode(String code);
}
