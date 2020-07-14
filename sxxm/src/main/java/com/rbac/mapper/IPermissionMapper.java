package com.rbac.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rbac.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IPermissionMapper extends BaseMapper<Permission> {
}
