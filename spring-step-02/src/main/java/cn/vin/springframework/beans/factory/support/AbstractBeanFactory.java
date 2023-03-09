package cn.vin.springframework.beans.factory.support;

import cn.vin.springframework.beans.BeansException;
import cn.vin.springframework.beans.factory.BeanFactory;
import cn.vin.springframework.beans.factory.config.BeanDefinition;


/**
 *模板设计模式
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) throws BeansException {
        Object bean = getSingleton(beanName);
        if (bean!=null){
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName,beanDefinition);
    }


    /**
     * bean 对象类
     * @param beanName
     * @return 结果集
     * @throws BeansException
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 创建bean
     * @param beanName
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

}
