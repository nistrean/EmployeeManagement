package com.utm.EmployeeManagement.repository.impl;

import com.utm.EmployeeManagement.entity.Department;
import com.utm.EmployeeManagement.entity.DepartmentDetails;
import com.utm.EmployeeManagement.entity.Employee;
import com.utm.EmployeeManagement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Department> findAll() {
        return jdbcTemplate.query("select * from department", (result, rownum)->
                new Department(
                        result.getInt("id"),
                        result.getString("dname"),
                        result.getInt("company_id")
                ));
    }

    @Override
    public DepartmentDetails findById(Integer id) {
        DepartmentDetails DepartmentDetails =
                jdbcTemplate.queryForObject("select * from department where id = ?",
                        (result, rowNum) ->
                                new DepartmentDetails(
                                        result.getInt("id"),
                                        result.getString("dname"),
                                        result.getInt("company_id")
                                ),id);

        List<Employee> employees = jdbcTemplate.query("select * from employee where department_id = ?",

                (result, rowNum) ->
                        new Employee(
                                result.getString("idnp"),
                                result.getString("first_name"),
                                result.getString("last_name"),
                                result.getString("email"),
                                result.getInt("company_id"),
                                result.getInt("department_id")
                        ),id);

        DepartmentDetails.setEmployees(employees);

        return DepartmentDetails;
    }

    @Override
    public void save(Department department) {
        jdbcTemplate.update(
                "insert into department values (?, ?, ?)",
                department.getId(), department.getDname(), department.getCompany_id());
    }

    @Override
    public void update(Integer id, Department department) {
        jdbcTemplate.update(
                "update department set dname = ?, company_id = ?  where id = ?",
                department.getDname(),department.getCompany_id(), id);
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update(
                "delete from department where id = ?", id);
    }

    @Override
    public boolean departmentExist(Integer id) {
        Integer count = jdbcTemplate.queryForObject("select count(*) from department where id = ?",
                Integer.class, id);
        return count > 0;
    }
}
