package cn.ffideal.order;

import cn.ffideal.order.config.FeignClientConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@MapperScan("cn.ffideal.order.mapper")
@SpringBootApplication
@EnableFeignClients(defaultConfiguration = FeignClientConfig.class)
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

}