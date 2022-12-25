package com.utm.EmployeeManagement.repository.impl;

import java.util.List;
import com.utm.EmployeeManagement.entity.Company;
import com.utm.EmployeeManagement.entity.CompanyDetails;
import com.utm.EmployeeManagement.entity.Department;
import com.utm.EmployeeManagement.entity.Employee;
import com.utm.EmployeeManagement.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyRepositoryImpl implements CompanyRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Company> findAll() {
        return jdbcTemplate.query("select * from company",
                (result, rowNum) ->
                new Company(
                        result.getInt("id"),
                        result.getString("cname"),
                        result.getString("address")
                ));
    }

    @Override
    public CompanyDetails findById(Integer id) {
        CompanyDetails CompanyDetails =
                jdbcTemplate.queryForObject("select * from company where id = ?",
                        (result, rowNum) ->
                        new CompanyDetails(
                                result.getInt("id"),
                                result.getString("cname"),
                                result.getString("address")
                        ),id);

        List<Department> departments = jdbcTemplate.query("select * from department where company_id = ?",
                (result, rowNum) ->
                        new Department(
                                result.getInt("id"),
                                result.getString("dname"),
                                result.getInt("company_id")
                        ),id);

        CompanyDetails.setDepartments(departments);

        List<Employee> employees = jdbcTemplate.query("select * from employee where company_id = ?",
                (result, rowNum) ->
                        new Employee(
                                result.getString("idnp"),
                                result.getString("first_name"),
                                result.getString("last_name"),
                                result.getString("email"),
                                result.getInt("company_id"),
                                result.getInt("department_id")
                        ),id);

        CompanyDetails.setEmployees(employees);

        return CompanyDetails;
    }

    @Override
    public void save(Company company) {
        jdbcTemplate.update(
                "insert into company values (?, ?, ?)",
                company.getId(), company.getCname(), company.getAddress());
    }

    @Override
    public void update(Integer id, Company company) {
        jdbcTemplate.update(
                "update company set cname = ?, address = ?  where id = ?",
                company.getCname(),company.getAddress(), id);
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update(
                "delete from company where id = ?", id);
    }

    @Override
    public boolean companyExist(Integer id) {
        Integer count = jdbcTemplate.queryForObject("select count(*) from company where id = ?",
                Integer.class, id);
        return count > 0;
    }
}

