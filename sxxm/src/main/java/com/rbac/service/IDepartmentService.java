package com.rbac.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rbac.entity.Department;

public interface IDepartmentService {
    void deleteDepartmentById(int id);
    void insertDepartment(Department department);
    void updateDepartmentById(Department department);

    /**
     * 设置分页
     * current 当前页面
     * size 页面大小
     * */
    IPage<Department> selectPage(int current, int size);
}
