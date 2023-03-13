package cn.vin.srpingframework.beans.factory.support;

import cn.vin.srpingframework.beans.BeansException;
import cn.vin.srpingframework.core.io.Resource;
import cn.vin.srpingframework.core.io.ResourceLoader;

/**
 * bean 定义读取接口
 * @author clustertech
 */
public interface BeanDefinitionReader {

    /**
     *
     * @return
     */
    BeanDefinitionRegistry getRegistry();


    /**
     * 获取资源加载 对象
     * @return
     */
    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource...resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;



}
