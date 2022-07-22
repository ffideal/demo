package com.ffideal.springboot_advance_demo.controller;

import co.elastic.clients.elasticsearch.ml.Page;
import com.ffideal.springboot_advance_demo.bean.Employee;
import com.ffideal.springboot_advance_demo.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
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

    // 添加文档
    @PostMapping("/es/save")
    public Employee saveEmployeeByES(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        System.out.println(employee);
        return employee;
    }

    // 修改文档,新增文档和修改文档操作，dao 层都是调用的 save() 方法
    @PostMapping("/es/update")
    public Employee updateEmployeeByES(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        log.info("===========================>" + employee);
        return employee;
    }


    // 根据ID查询文档
    @GetMapping("/es/{id}")
    public Employee getEmployeeByES(@PathVariable("id") Integer id){
        Employee emp = employeeService.getEmployee(id);
        return emp;
    }

    // 根据ID删除文档
    @DeleteMapping("/es/delete/{id}")
    public String deleteEmployeeByES(@PathVariable("id") Integer id) {
        employeeService.deleteEmoloyee(id);
        return "删除成功";
    }

    // 查询所有文档
    @RequestMapping("/es/getAll")
    public String getAll() {
        List<Employee> list = new ArrayList<>();
        Iterable<Employee> iterable = employeeService.getAll();
        iterable.forEach(e->list.add((Employee) e));
        return list.toString();
    }

    // 条件查询（单个条件）
    @GetMapping("/es/listByName")
    public List<Employee> getEmployeeByName(String lastName) {

        return employeeService.getEmployeeByName(lastName);
    }

    // 条件查询（多条件）
    @GetMapping("/es/listByNameAndId")
    public List<Employee> listByNameAndAge(String lastName, Integer id) {
        return employeeService.listByNameAndId(lastName, id);
    }

    @GetMapping("/es/listByNameAndIdAndGender")
    public List<Employee> listByNameAndAIdAndGender(String lastName, Integer id, Integer gender) {
        return employeeService.listByNameAndIdAndGender(lastName, id, gender);
    }

    // 分页查询（升序）
    @GetMapping("/es/listOrderByIdAsc")
    public List<Employee> listOrderByIdAsc() {
        return employeeService.listOrderByIdAscService();
    }

    // 分页查询
    @GetMapping("/es/page")
    public Page page(Integer pageNum, Integer pageSize) {
        return employeeService.getPage(pageNum, pageSize);
    }

    // 范围查询
    @GetMapping("/es/listGreaterThanId")
    public List<Employee> listGreaterThanid(Integer id) {
        return employeeService.getListGreaterThanId(id);
    }
}
