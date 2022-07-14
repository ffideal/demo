package com.ffideal.springboot_advance_demo.mapper;

import com.ffideal.springboot_advance_demo.bean.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id = #{id}")
    public Department getDepartment(Integer id);
}
