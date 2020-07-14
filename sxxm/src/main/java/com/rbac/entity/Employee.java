package com.rbac.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private String password;
    private String email;
    private Integer age;
    private Integer admin;
    private Integer dept_id;

    public Employee(String name, String password, String email, Integer age, Integer admin, Integer dept_id) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.age = age;
        this.admin = admin;
        this.dept_id = dept_id;
    }
}
