package com.utm.EmployeeManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DepartmentDetails {
    private Integer id;
    private String dname;
    private Integer company_id;

    private List<Employee> employees;

    public DepartmentDetails(Integer id,String dname,Integer company_id){
        this.id = id;
        this.dname = dname;
        this.company_id = company_id;
    }
}
