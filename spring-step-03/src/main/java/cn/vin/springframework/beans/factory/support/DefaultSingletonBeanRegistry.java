package cn.vin.springframework.beans.factory.support;


//import cn.vin.springframework.beans.factory.config.SingletonBeanRegistry;

import cn.vin.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private final Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }
    protected void addSingleton(String name,Object singletonObject){
        singletonObjects.put(name,singletonObject);

    }
}
