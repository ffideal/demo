package com.ffideal.spring.entity;

/**
 * @ClassName: Employee
 * @Description: TODO
 * @Author: ffideal
 * @Date: 2022/1/16 21:29
 * @Version: v1.0
 */

public class Employee {
    private String name;
    private Integer age;
    private String gender;

    public Employee() {
    }

    public Employee(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

//    @Override
//    public String toString() {
//        return "Employee{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", gender='" + gender + '\'' +
//                '}';
//    }
}
