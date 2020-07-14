package com.rbac.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rbac.entity.Department;
import com.rbac.entity.Role;
import com.rbac.mapper.IDepartmentMapper;
import com.rbac.service.IDepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Resource
    private IDepartmentMapper departmentMapper;

    @Override
    public void deleteDepartmentById(int id) {
        departmentMapper.deleteById(id);
    }

    @Override
    public void insertDepartment(Department department) {
        departmentMapper.insert(department);
    }

    @Override
    public void updateDepartmentById(Department department) {
        departmentMapper.updateById(department);
    }

    @Override
    public IPage<Department> selectPage(int current, int size) {
        Page<Department> page = new Page<>(current,size);
        return departmentMapper.selectPage(page,null);
    }


}
