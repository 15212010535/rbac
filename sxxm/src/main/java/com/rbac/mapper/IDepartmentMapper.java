package com.rbac.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rbac.entity.Department;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IDepartmentMapper extends BaseMapper<Department> {
}
