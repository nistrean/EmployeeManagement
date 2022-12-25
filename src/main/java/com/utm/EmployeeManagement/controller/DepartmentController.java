package com.utm.EmployeeManagement.controller;

import com.utm.EmployeeManagement.entity.Department;
import com.utm.EmployeeManagement.entity.DepartmentDetails;
import com.utm.EmployeeManagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getAll(){
        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    public DepartmentDetails getById(@PathVariable Integer id) {
        return departmentService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Department department) {
        departmentService.save(department);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody Department department) {
        departmentService.update(id,department);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        departmentService.delete(id);
    }
}
