package com.rbac.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
    private Integer id;
    private String name;
    private String expression;

    public Permission(String name, String expression) {
        this.name = name;
        this.expression = expression;
    }
}
