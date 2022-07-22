package com.ffideal.springboot_advance_demo.mapper;

import com.ffideal.springboot_advance_demo.bean.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeElasticSearchDao extends ElasticsearchRepository<Employee,Integer> {

    List<Employee> findBylastName(String lastName);

    List<Employee> findBylastNameAndId(String lastName, Integer id);

    List<Employee> findBylastNameAndIdAndGender(String lastName, Integer id, Integer gender);


    List<Employee> findByOrderByIdAsc();

    // 大于等于：findByIdGreaterThanEqual
    // 小于：findByIdLessThan
    // 小于等于：findByIdLessThanEqual
    List<Employee> findByIdGreaterThan(Integer id);
}
