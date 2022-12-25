package com.utm.EmployeeManagement.service;

import com.utm.EmployeeManagement.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findByIdnp(String idnp);

    void save(Employee employee);

    void update(String idnp, Employee employee);

    void delete(String idnp);
}
