package com.ffideal.springboot_advance_demo.mapper;


import com.ffideal.springboot_advance_demo.bean.Employee;
import com.ffideal.springboot_advance_demo.config.MyRedisConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Slf4j
@SpringBootTest
public class EmployeeTest {

    @Autowired
    public EmployeeMapper employeeMapper;


    @Autowired
    StringRedisTemplate stringRedisTemplate; // 操作k-v都是字符串的，因为操作字符串比较多

    @Autowired
    RedisTemplate redisTemplate;    // k-v都是对象

    @Autowired
    RedisTemplate<Object, Employee> empRedisTemplate;

    /**
     * String，list，set，hash，zset
     * stringRedisTemplate.opsForValue() ——> 操作字符串的
     * stringRedisTemplate.opsForList() ——> 操作列表的
     * stringRedisTemplate.opsForSet() ——> 操作集合的
     * stringRedisTemplate.opsForHash() ——> 操作散列的
     * stringRedisTemplate.opsForZset() ——> 操作有序集合的
     *
     * 同时 redisTemplate 也有以上的方法
     * */
    @Test
    public void testRedis() {
        // stringRedisTemplate.opsForValue().append("k2","testReids");
        String value = stringRedisTemplate.opsForValue().get("k2");
        log.info("==================》"+value);
    }

    @Test
    public void testRedisObject() {
        Employee emp = employeeMapper.getEmpById(1);
        redisTemplate.opsForValue().set("emp01_2",emp);
//        stringRedisTemplate.opsForValue().set("emp01",emp+"");
//        String value = stringRedisTemplate.opsForValue().get("k2");
    }

    @Test
    public void testRedisSerToJson() {
        Employee emp = employeeMapper.getEmpById(1);
        empRedisTemplate.opsForValue().set("emp01_ser",emp);
//        stringRedisTemplate.opsForValue().set("emp01",emp+"");
//        String value = stringRedisTemplate.opsForValue().get("k2");
    }

    // 测试插入
    @Test
    public void testInsert() {
        Employee emp = new Employee();
        emp.setLastName("lisi");
        emp.setEmail("lisi@ustc.edu");
        emp.setGender(1);
        emp.setdId(1);
        employeeMapper.insertEmp(emp);
    }

    // 测试查找
    @Test
    public void testSelect() {
        Employee emp = employeeMapper.getEmpById(1);
        System.out.println(emp);
    }



}
