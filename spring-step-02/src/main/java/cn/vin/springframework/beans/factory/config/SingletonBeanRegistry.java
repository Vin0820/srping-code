package cn.vin.springframework.beans.factory.config;

/**
 * @author clustertech
 */
public interface SingletonBeanRegistry {
    /**
     *
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);
}
