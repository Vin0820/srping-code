package cn.vin.springframework.beans.factory.support;

import cn.vin.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author clustertech
 */
public interface InstantiationStrategy {


    /**
     * 对象有属性
     * @param beanDefinition
     * @param name
     * @param constructor
     * @param args
     * @return
     */
    Object instantiate(BeanDefinition beanDefinition, String name, Constructor constructor, Object[] args);


}