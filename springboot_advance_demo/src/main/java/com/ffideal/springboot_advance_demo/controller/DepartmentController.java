package com.ffideal.springboot_advance_demo.controller;

import com.ffideal.springboot_advance_demo.bean.Department;
import com.ffideal.springboot_advance_demo.bean.Employee;
import com.ffideal.springboot_advance_demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {


    @Autowired
    DepartmentService departmentService;

    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        Department department = departmentService.getDepartment(id);
        return department;
    }
}
