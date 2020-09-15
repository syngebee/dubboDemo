package com.itheima.service.impl;

import com.itheima.pojo.UserAddress;
import com.itheima.service.UserService;

import java.util.ArrayList;
import java.util.List;


public class UserServiceImpl implements UserService {
    @Override
    public List<UserAddress> getUserAddressList() {
        System.out.println("方法执行");
/*        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        UserAddress userAddress1 = new UserAddress(1, "上海市浦东新区", "2", "陈老师", "13916427105", "true");
        UserAddress userAddress2 = new UserAddress(2, "上海市奉贤区", "3", "秦老师", "13916427105", "true");
        ArrayList<UserAddress> userAddresses = new ArrayList<>();
        userAddresses.add(userAddress1);
        userAddresses.add(userAddress2);
        return userAddresses;
    }
}
