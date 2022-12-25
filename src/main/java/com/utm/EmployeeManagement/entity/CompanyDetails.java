package com.utm.EmployeeManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CompanyDetails {
    private Integer id;
    private String cname;
    private String address;

    private List<Department> departments;

    private List<Employee> employees;

    public CompanyDetails(Integer id,String cname,String address){
        this.id = id;
        this.cname = cname;
        this.address = address;
    }
}
