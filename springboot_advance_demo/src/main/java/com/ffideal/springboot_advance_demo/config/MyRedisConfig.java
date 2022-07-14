package com.ffideal.springboot_advance_demo.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ffideal.springboot_advance_demo.bean.Department;
import com.ffideal.springboot_advance_demo.bean.Employee;
import com.ffideal.springboot_advance_demo.util.GenericityRedisUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
public class MyRedisConfig {





    @Bean
    public RedisTemplate<Object, Employee> empRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws Exception{
        RedisTemplate<Object, Employee> template = new RedisTemplate<Object, Employee>();
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        template.setConnectionFactory(redisConnectionFactory);
        // 专门用来转化employee的序列器
        Jackson2JsonRedisSerializer<Employee> employeeJackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Employee>(Employee.class);
        template.setKeySerializer(redisSerializer);
        template.setValueSerializer(employeeJackson2JsonRedisSerializer);
        template.setHashValueSerializer(employeeJackson2JsonRedisSerializer);
//        template.setDefaultSerializer(employeeJackson2JsonRedisSerializer);
        return template;
//        RedisTemplate<Object, Employee> redisTemplate= new GenericityRedisUnit<Object, Employee>().empRedisTemplate(redisConnectionFactory);
//        return redisTemplate;
    }

    @Bean
    public RedisTemplate<Object, Department> deptRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws Exception{
        RedisTemplate<Object, Department> template = new RedisTemplate<Object, Department>();
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        template.setConnectionFactory(redisConnectionFactory);
        // 专门用来转化employee的序列器
        Jackson2JsonRedisSerializer<Department> employeeJackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Department>(Department.class);
        template.setKeySerializer(redisSerializer);
        template.setValueSerializer(employeeJackson2JsonRedisSerializer);
        template.setHashValueSerializer(employeeJackson2JsonRedisSerializer);
//        template.setDefaultSerializer(employeeJackson2JsonRedisSerializer);
        return template;
//        RedisTemplate<Object, Employee> redisTemplate= new GenericityRedisUnit<Object, Employee>().empRedisTemplate(redisConnectionFactory);
//        return redisTemplate;
    }

    @Primary
    @Bean("empCacheManager")
    public CacheManager empCacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//解决查询缓存转换异常的问题
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                // 设置过期时间
                .entryTtl(Duration.ofSeconds(100))
                // 禁止缓存null对象
                .disableCachingNullValues()
                // 此处定义了cachekey的前缀，避免公司不同项目之间的key冲突
                .computePrefixWith(cacheName -> "yourAppName".concat(":").concat(cacheName).concat(":"))
                // 定义了key和value的序列化协议，同时hash key和hash value也被定义
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer))
                .disableCachingNullValues();
        RedisCacheManager manager = RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(cacheConfiguration).build();
        return manager;
    }
}
