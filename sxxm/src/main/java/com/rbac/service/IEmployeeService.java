package com.rbac.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rbac.entity.Employee;

public interface IEmployeeService {
    void deleteEmployeeById(int id);
    void saveAndUpdateEmployee(Employee employee);

    /**
     * 设置分页
     * current 当前页面
     * size 页面大小
     * */
    IPage<Employee> selectPage(int current, int size);
}
