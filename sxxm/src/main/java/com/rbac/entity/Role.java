package com.rbac.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Integer id;
    private String name;
    private String sn;
    public Role(String name, String sn) {
        this.name = name;
        this.sn = sn;
    }
}
