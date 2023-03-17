package cn.vin.srpingframework.context;

import cn.vin.srpingframework.beans.BeansException;

/**ConfigurableApplicationContext 继承ApplicationContext，并提供了refresh 这个核心方法。
 * @author clustertech
 */
public interface ConfigurableApplicationContext extends ApplicationContext {


    /**
     * 刷新容器
     * @throws  BeansException
     */
    void refresh() throws BeansException;


}
