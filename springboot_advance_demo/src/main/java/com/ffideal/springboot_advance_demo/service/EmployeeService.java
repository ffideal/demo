package com.ffideal.springboot_advance_demo.service;

import com.ffideal.springboot_advance_demo.bean.Department;
import com.ffideal.springboot_advance_demo.bean.Employee;
import com.ffideal.springboot_advance_demo.mapper.EmployeeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.*;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@CacheConfig(cacheManager = "empCacheManager")
@Slf4j
@Service
public class EmployeeService {

    @Autowired
    public EmployeeMapper employeeMapper;


    /**
     * @Cacheable 将方法的运行结果进行缓存，以后再要相同的数据，直接从缓存中获取，不用调用方法
     *
     * CacheManager 管理多个 Cache 组件的吗，对缓存的CRUD操作在Cache组建中，每一个缓存组件都有自己唯一一个名字<br/>
     * 比如有管理员工的缓存组件，有管理工资的缓存组件，部门的缓存组件
     * 几个属性：
     *      cacheNames/value：指定缓存的名字
     *      key/keyGenerator：缓存数据使用的key，可以用它来指定。默认是使用方法参数的值 比如 id - emp，也可以使用SpEL
     *      cacheManager:指定缓存管理器。比如一个缓存管理器使用HashMap，另一个缓存管理器使用Redis
     *      condition：指定符合条件的情况下进行缓存，比如 "condition = "#id>1"
     *      unless：否定缓存，当unless指定条件为true，方法的返回值就不会被缓存，比如 , unless = "result == null" 结果为空不缓存
     *      sync：是否开启异步模式
     * */
    @Cacheable(cacheNames = {"emp"})
    public Employee getEmp(Integer id){
        System.out.println("查找"+id+"号员工");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }

    @CachePut(cacheNames = {"emp"},key = "#employee.id")
    public Employee updateEmp(Employee employee) {
        employeeMapper.updateEmp(employee);
        log.info("========> 更新完成");
        return employee;
    }

    @CacheEvict(cacheNames = {"emp"}, key = "#id")
    public void deleteEmp(Integer id) {
        employeeMapper.deleteEmp(id);
        log.info("===========>删除成功");
    }

    @Caching(
            cacheable = {
                @Cacheable(cacheNames = {"emp"})
            },
            put = {
                    @CachePut(cacheNames = {"emp"}, key = "#result.id"),
                    @CachePut(cacheNames = {"emp"}, key = "#result.email")
            }
    )
    public Employee getEmpByLastName(String lastName) {
        Employee emp = employeeMapper.getEmpByLastName(lastName);
        log.info("======>通过lastName获取员工数据：" + emp);
        return emp;
    }

    @RabbitListener(queues = "ffideal")
    public void receive(Employee employee) {
        log.info("================>"+employee);
    }

    @RabbitListener(queues = "ffideal.news")
    public void receiveMessage(Message message) {
//        log.info("================>"+message.getBody());
//        log.info("================>"+message.getMessageProperties());
        System.out.println("---------------->" + message.getBody());
        System.out.println("---------------->"+message.getMessageProperties());
    }

}
