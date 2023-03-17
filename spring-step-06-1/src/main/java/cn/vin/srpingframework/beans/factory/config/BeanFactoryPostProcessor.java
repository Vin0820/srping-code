package cn.vin.srpingframework.beans.factory.config;

import cn.vin.srpingframework.beans.BeansException;
import cn.vin.srpingframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @author clustertech
 */
public interface BeanFactoryPostProcessor {


    /**
     * 在所有的 BeanDefinition 加载完成后，实例化Bean 对象之前，提供 改 BeanDefinition 属性的机制
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
