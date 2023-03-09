package cn.vin.springframework.beans.factory.support;

import cn.vin.springframework.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     * @param name 放进容器的key名
     * @Param beanDefinition 对象内容
     */

    void registryBeanDefinitionRegistry(String name, BeanDefinition beanDefinition);
}
