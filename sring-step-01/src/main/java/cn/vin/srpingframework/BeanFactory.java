package cn.vin.srpingframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author clustertech
 * 在bean工厂中实现了 bean的注册,这里注册是bean的定义信息。同时在类中还包括了过去bean的操作
 */
public class BeanFactory {

    private Map<String,BeanDefinition> beanDefinitionMap=new ConcurrentHashMap<String, BeanDefinition>();


    public Map<String, BeanDefinition> getBeanDefinitionMap() {
        return beanDefinitionMap;
    }

    public Object getBean(String name){
        return beanDefinitionMap.get(name).getBean();
    }

    public void  registerBeanDefinition(String name,BeanDefinition beanDefinition){

        beanDefinitionMap.put(name,beanDefinition);
    }
}
