package com.rbac.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rbac.entity.Role;


public interface IRoleService {
    IPage<Role> selectPage(int current, int size);
    void saveAndUpdateRole(Role role);
    void deleteRoleById(int id);
}
