package cn.vin.springframework.test;

import cn.vin.springframework.beans.factory.config.BeanDefinition;
import cn.vin.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.vin.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import cn.vin.springframework.test.bean.UserService;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_BeanFactory(){

        //1初始化beanFactory
        DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();

        //2注册bean
        BeanDefinition beanDefinition=new BeanDefinition(UserService.class);
        beanFactory.registryBeanDefinitionRegistry("userService",beanDefinition);


        //3、第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

        //第二次获取bean from Singleton
        UserService userService_singleton = (UserService) beanFactory.getSingleton("userService");
        userService_singleton.queryUserInfo();

    }

}
