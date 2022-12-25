package com.utm.EmployeeManagement.service.impl;

import com.utm.EmployeeManagement.entity.Company;
import com.utm.EmployeeManagement.entity.CompanyDetails;
import com.utm.EmployeeManagement.exception.AlreadyExistException;
import com.utm.EmployeeManagement.exception.NotFoundException;
import com.utm.EmployeeManagement.repository.CompanyRepository;
import com.utm.EmployeeManagement.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public CompanyDetails findById(Integer id) {
       if(!companyRepository.companyExist(id))
           throw new NotFoundException(
                   "Company with id = " + id + " not exist");

       return companyRepository.findById(id);
    }

    @Override
    public void save(Company company) {
        if(companyRepository.companyExist(company.getId()))
            throw new AlreadyExistException(
                    "Company with id = "+ company.getId() + " already exist");

        companyRepository.save(company);
    }

    @Override
    public void update(Integer id, Company company) {
        companyRepository.update(id,company);
    }

    @Override
    public void delete(Integer id) {
        companyRepository.delete(id);
    }
}
