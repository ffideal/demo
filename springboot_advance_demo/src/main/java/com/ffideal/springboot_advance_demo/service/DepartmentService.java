package com.ffideal.springboot_advance_demo.service;


import com.ffideal.springboot_advance_demo.bean.Department;
import com.ffideal.springboot_advance_demo.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = {"dept"})
@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Cacheable
    public Department getDepartment(Integer id) {
        System.out.println("查找"+id+"号部门");
        Department department = departmentMapper.getDepartment(id);
        return department;
    }
}
