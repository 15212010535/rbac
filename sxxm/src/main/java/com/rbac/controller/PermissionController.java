package com.rbac.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rbac.entity.Permission;
import com.rbac.service.IPermissionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Resource
    private IPermissionService permissionService;

    @RequestMapping("/selectPage")
    public  ModelAndView selectPage(@RequestParam(name = "current",required = true,defaultValue = "1") int current,
                                    @RequestParam(name = "size",required = true,defaultValue = "4") int size){
        ModelAndView mv = new ModelAndView();
        IPage<Permission> page = permissionService.selectPage(current, size);
        List<Permission> permissions = page.getRecords();
        mv.addObject("permissions",permissions);
        mv.addObject("page",page);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/deletePermissionById/{id}")
    public ModelAndView deletePermissionById(@PathVariable("id") Integer id){
        ModelAndView mv = new ModelAndView();
        permissionService.deletePermissionById(id);
        mv.setViewName("redirect:/permission/selectPage");
        return mv;
    }

    @RequestMapping("/saveAndUpdatePermission")
    public ModelAndView saveAndUpdatePermission(@ModelAttribute(value = "department") Permission permission){
        ModelAndView mv = new ModelAndView();
        permissionService.saveAndUpdatePermission(permission);
        mv.setViewName("redirect:/permission/selectPage");
        return mv;
    }

    @RequestMapping("/saveAndUpdate/{id}")
    public ModelAndView saveAndUpdate(@PathVariable("id") Integer id){
        ModelAndView mv =new ModelAndView();
        Permission permission = new Permission();
        permission.setId(id);
        mv.addObject("permission",permission);
        mv.setViewName("permission-saveAndUpdate");
        return mv;
    }
}
