package com.utm.EmployeeManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Department {
    private Integer id;
    private String dname;
    private Integer company_id;
}
