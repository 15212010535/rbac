package com.rbac.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rbac.entity.Employee;
import com.rbac.mapper.IEmployeeMapper;
import com.rbac.service.IEmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Resource
    private IEmployeeMapper employeeMapper;


    @Override
    public void deleteEmployeeById(int id) {
        employeeMapper.deleteById(id);
    }

    @Override
    public void saveAndUpdateEmployee(Employee employee) {
        if (employee.getId()==0){
            employeeMapper.insert(employee);
        }else {
            employeeMapper.updateById(employee);
        }
    }

    @Override
    public IPage<Employee> selectPage(int current, int size) {
        Page<Employee> page = new Page<>(current,size);
        return employeeMapper.selectPage(page,null);
    }

}
