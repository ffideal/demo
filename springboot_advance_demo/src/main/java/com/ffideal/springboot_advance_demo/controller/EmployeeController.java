package com.ffideal.springboot_advance_demo.controller;

import com.ffideal.springboot_advance_demo.bean.Employee;
import com.ffideal.springboot_advance_demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id){
        Employee emp = employeeService.getEmp(id);
        return emp;
    }

    @GetMapping("/emp")
    public Employee update(Employee employee) {
        Employee emp = employeeService.updateEmp(employee);
        return emp;
    }

    @GetMapping("/emp/delete/{id}")
    public String delete(@PathVariable("id")Integer id) {
        employeeService.deleteEmp(id);
        return "success";
    }

    @GetMapping("/emp/getEmp")
    public Employee getEmpByLastName(String lastName) {
        Employee emp = employeeService.getEmpByLastName(lastName);
        return emp;
    }
}
