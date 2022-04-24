package com.ffideal.spring.config;


import com.ffideal.spring.entity.Employee;
import org.springframework.context.annotation.*;

/**
 * @ClassName: EmpConfig
 * @Description: TODO
 * @Author: ffideal
 * @Date: 2022/1/16 21:44
 * @Version: v1.0
 */
@Configuration
@ComponentScan(value = "com.ffideal.spring")
public class EmpConfig {
    //@Bean注解是给IOC容器中注册一个bean，类型自然就是返回值的类型，id默认是用方法名作为id
//    @Bean("emp")
//	public Employee employee() {
//		System.out.println("添加一个Employee对象emp");
//		return new Employee("王五",26,"男");
//	}

	@Bean("Windows")
	public Employee employee01() {
		System.out.println("添加一个Employee对象Windows");
		return new Employee("Windows",24,"女");
	}

	@Bean("Linux")
	public Employee employee02() {
		System.out.println("添加一个Employee对象Linux");
		return new Employee("Linux",28,"男");
	}
}
