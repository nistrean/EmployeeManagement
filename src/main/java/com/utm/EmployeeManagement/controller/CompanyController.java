package com.utm.EmployeeManagement.controller;

import java.util.List;
import com.utm.EmployeeManagement.entity.Company;
import com.utm.EmployeeManagement.entity.CompanyDetails;
import com.utm.EmployeeManagement.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<Company> getAll() {
        return companyService.findAll();
    }

    @GetMapping("/{id}")
    public CompanyDetails getById(@PathVariable Integer id) {
        return companyService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Company university) {
        companyService.save(university);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody Company company) {
        companyService.update(id, company);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        companyService.delete(id);
    }
}
