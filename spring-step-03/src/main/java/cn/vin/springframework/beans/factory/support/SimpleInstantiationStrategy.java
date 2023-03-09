package cn.vin.springframework.beans.factory.support;

import cn.vin.springframework.beans.BeansException;
import cn.vin.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * jdk实例化
 * @author clustertech
 */
public class SimpleInstantiationStrategy  implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String name, Constructor constructor, Object[] args)  throws BeansException {
        Class clazz = beanDefinition.getBeanClass();

        try {
            if (constructor != null) {
                //不为空则为有参构造函数
                return clazz.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            } else {
                //否则为无参构造函数
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);

        }
    }
}
