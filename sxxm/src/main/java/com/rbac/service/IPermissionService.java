package com.rbac.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rbac.entity.Permission;

public interface IPermissionService {
    IPage<Permission> selectPage(int current, int size);
    void saveAndUpdatePermission(Permission Permission);
    void deletePermissionById(int id);
}
