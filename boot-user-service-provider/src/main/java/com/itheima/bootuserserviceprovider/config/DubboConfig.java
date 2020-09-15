package com.itheima.bootuserserviceprovider.config;

import com.alibaba.dubbo.config.*;
import com.itheima.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class DubboConfig {

    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("boot-user-service-provider");
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("127.0.0.1:2181");
        return registryConfig;
    }

    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20882);
        return protocolConfig;
    }

    @Bean
    public MonitorConfig monitorConfig(){
        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setProtocol("registry");
        return monitorConfig;
    }



    @Bean
    public ServiceConfig userServiceConfig(UserService userService){
        ServiceConfig<UserService> userServiceConfig = new ServiceConfig<>();
        userServiceConfig.setInterface(UserService.class);
        userServiceConfig.setRef(userService);
        userServiceConfig.setTimeout(2000);
        userServiceConfig.setRetries(3);
        userServiceConfig.setVersion("1.0.0");
        //方法级控制
        MethodConfig methodConfig = new MethodConfig();
        //设置方法名
        methodConfig.setName("getUserAddressList");
        methodConfig.setTimeout(1000);
        methodConfig.setRetries(4);

        ArrayList<MethodConfig> methodConfigs = new ArrayList<>();
        methodConfigs.add(methodConfig);
        userServiceConfig.setMethods(methodConfigs);

        return userServiceConfig;
    }
}
