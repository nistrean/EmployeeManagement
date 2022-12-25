package com.utm.EmployeeManagement.repository;

import com.utm.EmployeeManagement.entity.Company;
import com.utm.EmployeeManagement.entity.CompanyDetails;
import java.util.List;

public interface CompanyRepository {

    List<Company> findAll();

    CompanyDetails findById(Integer id);

    void save(Company company);

    void update(Integer id, Company company);

    void delete(Integer id);

    boolean companyExist(Integer id);
}
