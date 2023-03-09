package cn.vin.springframework.beans.factory;

import cn.vin.springframework.beans.BeansException;

/**
 * @author clustertech
 */
public interface BeanFactory {


    /**
     * 获取bean实例
     * @param beanName
     * @return 对象实例
     * @throws BeansException
     */
    Object getBean(String beanName) throws BeansException;
}
