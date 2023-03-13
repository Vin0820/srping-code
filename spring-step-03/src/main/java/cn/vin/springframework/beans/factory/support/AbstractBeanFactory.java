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
       return doGetBean(beanName,null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name,args);
    }

    protected <T> T doGetBean(final  String name,final  Object[] args){
        Object bean = getSingleton(name);
        if (bean!=null){
            return (T)bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T)createBean(name,beanDefinition,args);

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

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition,Object[] args ) throws BeansException;

}
