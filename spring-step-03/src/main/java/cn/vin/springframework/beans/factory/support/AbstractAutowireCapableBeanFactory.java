package cn.vin.springframework.beans.factory.support;


import cn.vin.springframework.beans.BeansException;
import cn.vin.springframework.beans.factory.config.BeanDefinition;

/**
 * @author clustertech
 */
public class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        return null;
    }

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        return null;
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return null;
    }
}
