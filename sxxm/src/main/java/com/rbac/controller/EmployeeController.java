package com.rbac.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rbac.entity.Department;
import com.rbac.entity.Employee;
import com.rbac.service.IEmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Resource
    private IEmployeeService employeeService;

    @RequestMapping("/selectPage")
    public  ModelAndView selectPage(@RequestParam(name = "current",required = true,defaultValue = "1") int current,
                                    @RequestParam(name = "size",required = true,defaultValue = "4") int size){
        ModelAndView mv = new ModelAndView();
        IPage<Employee> page = employeeService.selectPage(current, size);
        List<Employee> employees = page.getRecords();
        mv.addObject("employees",employees);
        mv.addObject("page",page);
        mv.setViewName("employee-list");
        return mv;
    }

    @RequestMapping("/deleteEmployeeById/{id}")
    public ModelAndView deleteEmployeeById(@PathVariable("id") Integer id){
        ModelAndView mv = new ModelAndView();
        employeeService.deleteEmployeeById(id);
        mv.setViewName("redirect:/employee/selectPage");
        return mv;
    }

    @RequestMapping("/saveAndUpdateEmployee")
    public ModelAndView saveAndUpdateEmployee(@ModelAttribute(value = "department") Employee employee){
        ModelAndView mv = new ModelAndView();
        employeeService.saveAndUpdateEmployee(employee);
        mv.setViewName("redirect:/employee/selectPage");
        return mv;
    }

    @RequestMapping("/saveAndUpdate/{id}")
    public ModelAndView saveAndUpdate(@PathVariable("id") Integer id){
        ModelAndView mv =new ModelAndView();
        Employee employee = new Employee();
        employee.setId(id);
        mv.addObject("employee",employee);
        System.out.println(employee);
        mv.setViewName("employee-saveAndUpdate");
        return mv;
    }
}
