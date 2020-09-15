package com.itheima.service.impl;

import com.itheima.pojo.UserAddress;
import com.itheima.service.OrderService;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  1. 将服务提供者注册到注册中心(暴露服务)
 *      1)导入dubbo的依赖 \ 操作zookeeper的客户端
 *      2)配置服务提供者
 *  2. 让服务消费者取注册中心订阅服务提供者的服务地址
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    UserService userService;

    @Override
    public List<UserAddress> initOrder() {
        return userService.getUserAddressList();
    }
}
