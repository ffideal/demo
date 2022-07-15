package com.ffideal.springboot_advance_demo.util;

import com.ffideal.springboot_advance_demo.bean.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Type;

/**
 * 用以创建一个类，用以快速生成Json与Redis 的结合
 * */
public class GenericityRedisUnit<K,V> {
    private K K;
    private V V;

    /**
     * 创建泛型
     * */

//    public RedisTemplate<K, V> empRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws Exception{
//        RedisTemplate<K, V> template = new RedisTemplate<K, V>();
//        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
//        template.setConnectionFactory(redisConnectionFactory);
//        Type type = getClass().getGenericSuperclass();
//
//        // 专门用来转化employee的序列器
//        Jackson2JsonRedisSerializer<V> employeeJackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<V>(V.class);
//        template.setKeySerializer(redisSerializer);
//        template.setValueSerializer(employeeJackson2JsonRedisSerializer);
//        template.setHashValueSerializer(employeeJackson2JsonRedisSerializer);
////        template.setDefaultSerializer(employeeJackson2JsonRedisSerializer);
//        return template;
//    }
}
