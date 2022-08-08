package cn.ffideal.order.config;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IRuleConfig {

    /** ribbon 负载均衡
     * 对所有order-service调用的微服务做负载均衡
     * */
//    @Bean
//    public IRule randomRule(){
//        return new RandomRule();
//    }

}
