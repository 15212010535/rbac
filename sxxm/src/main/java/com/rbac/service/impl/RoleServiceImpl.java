package com.rbac.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rbac.entity.Role;
import com.rbac.mapper.IRoleMapper;
import com.rbac.service.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Resource
    private IRoleMapper roleMapper;


    @Override
    public IPage<Role> selectPage(int current, int size) {

        Page<Role> page = new Page<>(current,size);
        Page<Role> rolePage = roleMapper.selectPage(page, null);
        return rolePage;
    }

    @Override
    public void saveAndUpdateRole(Role role) {
        if (role.getId()==0){
            roleMapper.insert(role);
        }else {
            roleMapper.updateById(role);
        }
    }

    @Override
    public void deleteRoleById(int id) {
        roleMapper.deleteById(id);
    }
}
