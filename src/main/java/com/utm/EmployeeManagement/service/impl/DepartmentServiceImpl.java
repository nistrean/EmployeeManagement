package com.utm.EmployeeManagement.service.impl;

import com.utm.EmployeeManagement.entity.Department;
import com.utm.EmployeeManagement.entity.DepartmentDetails;
import com.utm.EmployeeManagement.exception.AlreadyExistException;
import com.utm.EmployeeManagement.exception.NotFoundException;
import com.utm.EmployeeManagement.repository.DepartmentRepository;
import com.utm.EmployeeManagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public DepartmentDetails findById(Integer id) {
        if(!departmentRepository.departmentExist(id))
            throw new NotFoundException(
                    "Department with id = " + id + " not found");

        return departmentRepository.findById(id);
    }

    @Override
    public void save(Department department) {
        if(departmentRepository.departmentExist(department.getId()))
            throw new AlreadyExistException(
                    "Department with id = " + department.getId() + " already exist");

        departmentRepository.save(department);
    }

    @Override
    public void update(Integer id, Department department) {
        departmentRepository.update(id, department);
    }

    @Override
    public void delete(Integer id) {
        departmentRepository.delete(id);
    }
}
