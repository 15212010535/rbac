package com.rbac.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rbac.entity.Permission;
import com.rbac.entity.Role;
import com.rbac.service.IRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Resource
    private IRoleService roleService;

    @RequestMapping("/selectPage")
    public  ModelAndView selectPage(@RequestParam(name = "current",required = true,defaultValue = "1") int current,
                                    @RequestParam(name = "size",required = true,defaultValue = "4") int size){
        ModelAndView mv = new ModelAndView();
        IPage<Role> page = roleService.selectPage(current, size);
        List<Role> roles = page.getRecords();
        mv.addObject("roles",roles);
        mv.addObject("page",page);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/deleteRoleById/{id}")
    public ModelAndView deletePermissionById(@PathVariable("id") Integer id){
        ModelAndView mv = new ModelAndView();
        roleService.deleteRoleById(id);
        mv.setViewName("redirect:/role/selectPage");
        return mv;
    }

    @RequestMapping("/saveAndUpdateRole")
    public ModelAndView saveAndUpdateRole(@ModelAttribute(value = "department") Role role){
        ModelAndView mv = new ModelAndView();
        roleService.saveAndUpdateRole(role);
        mv.setViewName("redirect:/role/selectPage");
        return mv;
    }

    @RequestMapping("/saveAndUpdate/{id}")
    public ModelAndView saveAndUpdate(@PathVariable("id") Integer id){
        ModelAndView mv =new ModelAndView();
        Role role = new Role();
        role.setId(id);
        mv.addObject("role",role);
        mv.setViewName("role-saveAndUpdate");
        return mv;
    }

}
