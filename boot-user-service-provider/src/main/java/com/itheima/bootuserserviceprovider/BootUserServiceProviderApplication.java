package com.itheima.bootuserserviceprovider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * 导入依赖
 *      1.dubbo-starter
 *      2.dubbo的其他依赖
 *      3.开启dubbo基于注解的支持
 * 开启容错机制的支持
 */
@SpringBootApplication
@EnableHystrix
@EnableDubbo(scanBasePackages = "com.itheima.bootuserserviceprovider")
public class BootUserServiceProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootUserServiceProviderApplication.class, args);
    }

}
