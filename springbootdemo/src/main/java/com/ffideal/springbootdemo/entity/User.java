package com.ffideal.springbootdemo.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: User
 * @Description: TODO
 * @Author: ffideal
 * @Date: 2022/4/16 14:50
 * @Version: v1.0
 */

@ConfigurationProperties(prefix = "user")
@Component
public class User {
    private String userName;
    private int age;
    private int gender;
    private String phone;
    private List<String> interest;
    private List<String> books;
    private Map<String, Object> allPets;

    public List<String> getInterest() {
        return interest;
    }

    public void setInterest(List<String> interest) {
        this.interest = interest;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }


    public Map<String, Object> getAllPets() {
        return allPets;
    }

    public void setAllPets(Map<String, Object> allPets) {
        this.allPets = allPets;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User() {

    }


    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", interest=" + interest +
                ", books=" + books +
                ", allPets=" + allPets +
                '}';
    }
}
