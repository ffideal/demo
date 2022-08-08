package cn.ffideal.order.service;

import cn.ffideal.order.client.UserClient;
import cn.ffideal.order.mapper.OrderMapper;
import cn.ffideal.order.pojo.Order;
import cn.ffideal.order.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private UserClient userClient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 2. 利用RestTemplate发送http请求，查询用户
//        String url = "http://userservice:8081/user/" + order.getUserId();
//        User user = restTemplate.getForObject(url, User.class);
        User user = userClient.findById(order.getUserId());
        // 3.封装User到Order
        order.setUser(user);
        // 4.返回
        return order;
    }
}
