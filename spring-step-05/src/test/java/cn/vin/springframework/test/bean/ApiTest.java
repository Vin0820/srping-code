package cn.vin.springframework.test.bean;

import cn.hutool.core.io.IoUtil;
import cn.vin.srpingframework.beans.PropertyValue;
import cn.vin.srpingframework.beans.PropertyValues;
import cn.vin.srpingframework.beans.factory.config.BeanDefinition;
import cn.vin.srpingframework.beans.factory.config.BeanReference;
import cn.vin.srpingframework.beans.factory.support.DefaultListableBeanFactory;
import cn.vin.srpingframework.core.io.DefaultResourceLoader;
import cn.vin.srpingframework.core.io.Resource;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class ApiTest {


    @Test
    public  void test_BeanFactory(){
        //1、初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //类对象都要进入beanDefinitionMap 否则会一场 判断的时候是根据 value 是不是改类型 BeanDefinition
       beanFactory.registerBeanDefinition("userDao",new BeanDefinition(UserDao.class));

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

    private DefaultResourceLoader resourceLoader;

    @Before
    public void inti(){
        this.resourceLoader=new DefaultResourceLoader();
    }




    @Test
    public void test_classPath () throws IOException{
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String s = IoUtil.readUtf8(inputStream);
        System.out.println("s = " + s);


    }

}
