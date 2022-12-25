package com.utm.EmployeeManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Company {
    private Integer id;
    private String cname;
    private String address;
}
