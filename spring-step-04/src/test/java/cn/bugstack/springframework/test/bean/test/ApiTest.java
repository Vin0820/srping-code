package cn.bugstack.springframework.test.bean.test;

import cn.bugstack.springframework.beans.factory.PropertyValue;
import cn.bugstack.springframework.beans.factory.PropertyValues;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import cn.bugstack.springframework.beans.factory.config.BeanReference;
import cn.bugstack.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.bugstack.springframework.test.bean.UserDao;
import cn.bugstack.springframework.test.bean.UserService;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. UserDao 注册  就是信息放到一个beanDefinitionMap HashMap的容器中
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 3. UserService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        //给 propertyValues 中的propertyValueList add对象的属性
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        // 4. UserService 注入bean   就是调用beanDefinition的构造方法
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        //然后再把 beanDefinition 注册到DefaultListableBeanFactory beanFactory 中的beanDefinitionMap 中
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 5. UserService 获取bean 采用cglib动态 beanFactory.getBean 调用 doGetBean方法 会去调用DefaultSingletonBeanRegistry 里面的 getSingleton方法 就是singletonObjects根据key获取value 为空则
        // 调用 DefaultListableBeanFactory 根据key获取value获取 到BeanDefinition对象
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

}
