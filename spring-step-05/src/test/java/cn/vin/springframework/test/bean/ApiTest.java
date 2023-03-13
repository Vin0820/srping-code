package cn.vin.springframework.test.bean;

import cn.vin.srpingframework.beans.PropertyValue;
import cn.vin.srpingframework.beans.PropertyValues;
import cn.vin.srpingframework.beans.factory.config.BeanDefinition;
import cn.vin.srpingframework.beans.factory.config.BeanReference;
import cn.vin.srpingframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

public class ApiTest {


    @Test
    public  void test_BeanFactory(){
        //1、初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //2、进行userDao注册

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId","10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));


        //进行userService 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService",beanDefinition);



        //5、userService 获取bean
        UserService userService = (UserService)beanFactory.getBean("userService");
        userService.queryUserInfo();


    }

}
