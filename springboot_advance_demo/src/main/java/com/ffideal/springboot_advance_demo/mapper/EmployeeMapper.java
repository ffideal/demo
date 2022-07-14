package com.ffideal.springboot_advance_demo.mapper;

import com.ffideal.springboot_advance_demo.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {

    // 根据id查找一个员工
    @Select("select * from employee where id = #{id}")
    public Employee getEmpById(Integer id);

    // 更新员工信息
    @Update("update employee set lastName = #{lastName}, email = #{email}, gender = #{gender}, d_id=#{dId} where id=#{id}")
    public void updateEmp(Employee emp);

    // 根据id删除一个员工信息
    @Delete("delete from employee where id = #{id}")
    public void deleteEmp(Integer id);

    // 插入一个员工
    @Insert("insert into employee(lastName, email, gender, d_id) values(#{lastName},#{email},#{gender},#{dId})")
    public void insertEmp(Employee emp);

    // 按名称来查询员工
    @Select("select * from employee where lastName = #{lastName}")
    public Employee getEmpByLastName(String lastName);
}
