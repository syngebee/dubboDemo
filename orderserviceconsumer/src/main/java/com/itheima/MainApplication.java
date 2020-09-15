package com.itheima;

import com.itheima.service.impl.OrderServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("consumer.xml");
        OrderServiceImpl orderService = ac.getBean(OrderServiceImpl.class);
        orderService.initOrder();
        System.out.println("调用完成");
    }
}
