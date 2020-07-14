package com.rbac.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String sn;
    public Department(String name, String sn) {
        this.name = name;
        this.sn = sn;
    }
}
