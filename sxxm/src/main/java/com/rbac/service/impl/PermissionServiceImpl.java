package com.rbac.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rbac.entity.Permission;
import com.rbac.mapper.IPermissionMapper;
import com.rbac.service.IPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PermissionServiceImpl implements IPermissionService {

    @Resource
    private IPermissionMapper permissionMapper;

    @Override
    public void deletePermissionById(int id) {
        permissionMapper.deleteById(id);
    }

    @Override
    public void saveAndUpdatePermission(Permission Permission) {
        if (Permission.getId()==0){
            permissionMapper.insert(Permission);
        }else {
            permissionMapper.updateById(Permission);
        }
    }

    @Override
    public IPage<Permission> selectPage(int current, int size) {
        Page<Permission> page = new Page<>(current,size);
        return permissionMapper.selectPage(page,null);
    }
    
}
