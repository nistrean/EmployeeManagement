package com.utm.EmployeeManagement.repository.impl;

import java.util.List;

import com.utm.EmployeeManagement.entity.Employee;
import com.utm.EmployeeManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Employee employee) {
        jdbcTemplate.update("insert into employee values (?, ?, ?, ?, ?, ?)",
                employee.getIdnp(), employee.getFirst_name(), employee.getLast_name(),
                employee.getEmail(),employee.getDepartment_id(),employee.getCompany_id());
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query("select * from employee", (employee, rowNum) ->
                new Employee(
                        employee.getString("idnp"),
                        employee.getString("first_name"),
                        employee.getString("last_name"),
                        employee.getString("email"),
                        employee.getInt("company_id"),
                        employee.getInt("department_id")
                ));
    }

    @Override
    public Employee findByIdnp(String idnp) {
        return jdbcTemplate.queryForObject("select * from employee where idnp = ?",
                (employee, rowNum) ->
                        new Employee(
                                employee.getString("idnp"),
                                employee.getString("first_name"),
                                employee.getString("last_name"),
                                employee.getString("email"),
                                employee.getInt("company_id"),
                                employee.getInt("department_id")
                        ), idnp);
    }

    @Override
    public void update(String idnp, Employee employee) {
        jdbcTemplate.update(
                "update employee set first_name = ?, last_name = ?, email = ?, company_id = ?,department_id = ?  where idnp = ?",
                employee.getFirst_name(), employee.getLast_name(), employee.getEmail(), employee.getCompany_id(), employee.getDepartment_id(), idnp);
    }

    @Override
    public void delete(String idnp) {
        jdbcTemplate.update(
                "delete from employee where idnp = ?", idnp);
    }

    @Override
    public boolean employeeExist(String idnp) {
        Integer count = jdbcTemplate.queryForObject("select count(*) from employee where idnp = ?",
                Integer.class, idnp);
        return count > 0;
    }
}
