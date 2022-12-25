package com.utm.EmployeeManagement.repository;

import com.utm.EmployeeManagement.entity.Department;
import com.utm.EmployeeManagement.entity.DepartmentDetails;

import java.util.List;

public interface DepartmentRepository {

    List<Department> findAll();

    DepartmentDetails findById(Integer id);

    void save(Department department);

    void update(Integer id,Department department);

    void delete(Integer id);

    boolean departmentExist(Integer id);
}
