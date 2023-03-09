package cn.vin.springframework.beans.factory.config;

/**
 * @author clustertech
 */
public interface SingletonBeanRegistry {
    /**
     *
     * @param beanName
     * @return 结果
     */
    Object getSingleton(String beanName);
}
