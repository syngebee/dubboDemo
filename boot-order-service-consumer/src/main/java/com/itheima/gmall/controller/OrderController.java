package com.itheima.gmall.controller;

import com.itheima.pojo.UserAddress;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/initOrder")
    public @ResponseBody List<UserAddress> initOrder(){
        return orderService.initOrder();
    }
}
