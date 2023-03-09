package cn.vin.springframework.beans.factory.support;

import cn.vin.springframework.beans.BeansException;
import cn.vin.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private Map<String,BeanDefinition> stringObjectMap=new HashMap<String, BeanDefinition>();

    @Override
    public void registryBeanDefinitionRegistry(String name, BeanDefinition beanDefinition) {
        stringObjectMap.put(name,beanDefinition);

    }

    @Override
    public  BeanDefinition getBeanDefinition(String name) {
        BeanDefinition beanDefinition = stringObjectMap.get(name);
        if (beanDefinition==null){
        throw new BeansException("No bean named " + name + " is defined\"");
        }
        return beanDefinition;
    }
}
