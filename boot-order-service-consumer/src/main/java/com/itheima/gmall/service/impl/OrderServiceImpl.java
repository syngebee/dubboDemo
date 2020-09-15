package com.itheima.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.pojo.UserAddress;
import com.itheima.service.OrderService;
import com.itheima.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 *  1. 将服务提供者注册到注册中心(暴露服务)
 *      1)导入dubbo的依赖 \ 操作zookeeper的客户端
 *      2)配置服务提供者
 *  2. 让服务消费者取注册中心订阅服务提供者的服务地址
 */
@Service
public class OrderServiceImpl implements OrderService {

//    @Reference(url="127.0.0.1:20881")
    @Reference
    private UserService userService;

    @Override
    @HystrixCommand(fallbackMethod = "hello")
    public List<UserAddress> initOrder() {
        List<UserAddress> userAddressList = userService.getUserAddressList();
/*        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return userAddressList;
    }

    public List<UserAddress> hello(){
        System.out.println("容错回调函数被执行了");
        return Arrays.asList(
                new UserAddress(100,"容错-地址1","uid1","consignee","123","true"),
                new UserAddress(101,"容错-地址2","uid2","consignee","123","true"),
                new UserAddress(102,"容错-地址3","uid3","consignee","123","true")
        );
    }
}
