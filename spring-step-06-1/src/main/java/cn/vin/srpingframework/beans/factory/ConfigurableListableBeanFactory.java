package cn.vin.srpingframework.beans.factory;


import cn.vin.srpingframework.beans.BeansException;
import cn.vin.srpingframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.vin.srpingframework.beans.factory.config.BeanDefinition;
import cn.vin.srpingframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * Configuration interface to be implemented by most listable bean factories.
 * In addition to {@link ConfigurableBeanFactory}, it provides facilities to
 * analyze and modify bean definitions, and to pre-instantiate singletons.
 *
 *
 *
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

}
