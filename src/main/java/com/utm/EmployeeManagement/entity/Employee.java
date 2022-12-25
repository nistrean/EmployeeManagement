package com.utm.EmployeeManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {

    private String idnp;

    private String first_name;

    private String last_name;

    private String email;

    private Integer department_id;

    private Integer company_id;
}
