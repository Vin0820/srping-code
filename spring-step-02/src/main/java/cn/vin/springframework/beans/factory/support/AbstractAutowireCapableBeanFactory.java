package cn.vin.springframework.beans.factory.support;

import cn.vin.springframework.beans.BeansException;
import cn.vin.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{


    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean ;
        try {
            bean=beanDefinition.getBeanClass().newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            throw new BeansException("Instantiation of bean failed",e );
        }
        addSingleton(beanName,bean);
        return bean;
    }
}
