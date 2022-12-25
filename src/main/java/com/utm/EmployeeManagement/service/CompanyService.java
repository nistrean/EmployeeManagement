package com.utm.EmployeeManagement.service;

import com.utm.EmployeeManagement.entity.Company;
import com.utm.EmployeeManagement.entity.CompanyDetails;

import java.util.List;

public interface CompanyService {

    List<Company> findAll();

    CompanyDetails findById(Integer id);

    void save(Company company);

    void update(Integer  id, Company company);

    void delete(Integer id);
}
