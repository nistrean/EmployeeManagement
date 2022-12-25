package com.utm.EmployeeManagement.service.impl;

import com.utm.EmployeeManagement.exception.NotFoundException;
import com.utm.EmployeeManagement.exception.AlreadyExistException;
import com.utm.EmployeeManagement.entity.Employee;
import com.utm.EmployeeManagement.repository.EmployeeRepository;
import com.utm.EmployeeManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findByIdnp(String idnp) {
        if(!employeeRepository.employeeExist(idnp))
            throw new NotFoundException(
                    "Employee with idnp = " + idnp + " not found");

        return employeeRepository.findByIdnp(idnp);
    }

    @Override
    public void save(Employee employee) {
        if(employeeRepository.employeeExist(employee.getIdnp()))
            throw new AlreadyExistException(
                    "Employee with idnp = " + employee.getIdnp() + " already exist");

        employeeRepository.save(employee);
    }

    @Override
    public void update(String idnp, Employee employee) {
        employeeRepository.update(idnp, employee);
    }

    @Override
    public void delete(String idnp) {
        employeeRepository.delete(idnp);
    }
}

