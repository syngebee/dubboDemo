package com.itheima.bootuserserviceprovider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.pojo.UserAddress;
import com.itheima.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class UserServiceImpl implements UserService {

    @HystrixCommand
    @Override
    public List<UserAddress> getUserAddressList() {
        System.out.println("userService2");
        UserAddress userAddress1 = new UserAddress(1, "上海市浦东新区", "2", "陈老师", "13916427105", "true");
        UserAddress userAddress2 = new UserAddress(2, "上海市奉贤区", "3", "秦老师", "13916427105", "true");
        ArrayList<UserAddress> userAddresses = new ArrayList<>();
        userAddresses.add(userAddress1);
        userAddresses.add(userAddress2);
        double random = Math.random();
        System.out.println(random);
        if (random>0.8){
            throw new RuntimeException("测试容错");
        }
        return userAddresses;
    }
}
