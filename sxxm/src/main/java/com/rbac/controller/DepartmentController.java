package com.rbac.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rbac.entity.Department;
import com.rbac.service.IDepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Resource
    private IDepartmentService departmentService;

    @RequestMapping("/deleteDepartmentById/{id}")
    public ModelAndView deleteDepartmentById(@PathVariable("id") Integer id){
        ModelAndView mv = new ModelAndView();
        departmentService.deleteDepartmentById(id);
        mv.setViewName("redirect:/department/selectPage");
        return mv;
    }

    @RequestMapping("/insertDepartment")
    public ModelAndView insertDepartment(@ModelAttribute(value = "department") Department department){
        ModelAndView mv = new ModelAndView();
        if (department.getId()==0){
            departmentService.insertDepartment(department);
        }else {
            departmentService.updateDepartmentById(department);
        }
        mv.setViewName("redirect:/department/selectPage");
        return mv;
    }

    @RequestMapping("/updateDepartmentById")
    public void updateDepartmentById(@RequestBody Department department){
        departmentService.updateDepartmentById(department);
    }

    @RequestMapping("/selectPage")
    public ModelAndView selectPage(@RequestParam(name = "current",required = true,defaultValue = "1") int current,
                                  @RequestParam(name = "size",required = true,defaultValue = "4") int size){
        IPage<Department> page = departmentService.selectPage(current, size);
        List<Department> departments = page.getRecords();
        ModelAndView mv = new ModelAndView();
        mv.addObject("departments",departments);
        mv.addObject("page",page);
        mv.setViewName("department-list");
        return mv;
    }

    @RequestMapping("/saveAndUpdate/{id}")
    public ModelAndView saveAndUpdate(@PathVariable("id") Integer id){
        ModelAndView mv =new ModelAndView();
        Department department = new Department();
        department.setId(id);
        mv.addObject("department",department);
        System.out.println(department);
        mv.setViewName("department-saveAndUpdate");
        return mv;
    }

}
