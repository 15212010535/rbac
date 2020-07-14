package com.rbac.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rbac.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IEmployeeMapper extends BaseMapper<Employee> {
}
