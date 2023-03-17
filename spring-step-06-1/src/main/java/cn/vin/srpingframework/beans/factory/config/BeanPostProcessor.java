package cn.vin.srpingframework.beans.factory.config;

import cn.hutool.core.bean.BeanException;

/**
 * @author clustertech
 */
public interface BeanPostProcessor {

    /**
     * 在bean对象执行初始化之前，执行该方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeanException
     */

    Object postProcessBeforeInitialization(Object bean,String beanName) throws BeanException;


    /**
     * 在bean 对象执行初始化方法之后，执行此方法
     * @param bean
     * @param name
     * @return
     * @throws BeanException
     */

    Object postProcessAfterInitialization(Object bean,String name) throws BeanException;






}
