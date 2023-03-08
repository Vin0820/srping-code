package com.vin.springframework.test;

import cn.vin.srpingframework.BeanDefinition;
import cn.vin.srpingframework.BeanFactory;
import com.vin.springframework.test.bean.UserService;
import org.junit.Test;

public class ApiTest {


    @Test
    public void test_beanFactory(){
        BeanFactory beanFactory=new BeanFactory();

        BeanDefinition beanDefinition=new BeanDefinition(new UserService());

        beanFactory.registerBeanDefinition("userService",beanDefinition);

        UserService userService =(UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
