package com.utm.EmployeeManagement.repository;

import com.utm.EmployeeManagement.entity.Employee;
import java.util.List;

public interface EmployeeRepository {

    void save(Employee employee);

    List<Employee> findAll();

    Employee findByIdnp(String idnp);

    void update(String idnp, Employee employee);

    void delete(String idnp);

    boolean employeeExist(String idnp);
}
