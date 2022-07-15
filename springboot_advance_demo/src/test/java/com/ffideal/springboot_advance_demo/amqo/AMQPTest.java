package com.ffideal.springboot_advance_demo.amqo;

import com.ffideal.springboot_advance_demo.bean.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@SpringBootTest
public class AMQPTest {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;


    @Test
    public void createExchange() {
        amqpAdmin.declareExchange(new DirectExchange("exchange.admin"));
        log.info("交换机创建完毕");
        amqpAdmin.declareQueue(new Queue("queue.admin"));
        log.info("queue.admin队列创建完毕");
        amqpAdmin.declareBinding(new Binding("queue.admin",Binding.DestinationType.QUEUE,"exchange.admin","amqp.rabbitmq",null));
    }
    /**
     * 单播
     * */
    @Test
    public void contextLoads() {
        // Message 需要自己构造一个，定义信息体内容和信息头
        // rabbitTemplate.send(exchange,routeKey,message);

        // object 默认成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq
        //rabbitTemplate.convertAndSend(exchange,routeKey,object);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("msg","这是第一个消息");
        map.put("data", Arrays.asList("ffideal", 123, true));
        // rabbitTemplate.convertAndSend("exchange.direct","ffideal",map);
        rabbitTemplate.convertAndSend("exchange.direct","ffideal.news",new Employee(2,"张三","ffideal@qq.com",1,1));
    }


    @Test
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert("ffideal.news");
        System.out.println("========>" + o.getClass());
        System.out.println(o.toString());
    }

    /**
     * 广播
     * */
    @Test
    public void sendMsg() {
        // Message 需要自己构造一个，定义信息体内容和信息头
        // rabbitTemplate.send(exchange,routeKey,message);

        // object 默认成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq
        //rabbitTemplate.convertAndSend(exchange,routeKey,object);

        rabbitTemplate.convertAndSend("exchange.fanout","",new Employee(1,"张三","ffideal@qq.com",1,1));
    }

}
