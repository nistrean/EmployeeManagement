package com.utm.EmployeeManagement.controller;

import com.utm.EmployeeManagement.entity.Employee;
import com.utm.EmployeeManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll(){
        return employeeService.findAll();
    }

    @GetMapping("/{idnp}")
    public Employee getByIdnp(@PathVariable String idnp){
        return employeeService.findByIdnp(idnp);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Employee employee){
        employeeService.save(employee);
    }

    @PutMapping("/{idnp}")
    public void update(@PathVariable String idnp, @RequestBody Employee employee) {
        employeeService.update(idnp, employee);
    }

    @DeleteMapping("/{idnp}")
    public void delete(@PathVariable String idnp) {
        employeeService.delete(idnp);
    }
}
