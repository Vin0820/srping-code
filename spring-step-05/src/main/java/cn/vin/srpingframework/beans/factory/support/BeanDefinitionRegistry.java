package cn.vin.srpingframework.beans.factory.support;


import cn.vin.srpingframework.beans.factory.config.BeanDefinition;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);


    /**
     * 判断是否包含指定名称的BeanDefinition
     * @Parm beanName
     *
     */
    boolean containsBeanDefintion(String beanName);

}
