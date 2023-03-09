package cn.vin.springframework.beans.factory.config;

/**
 * @author clustertech
 */
public class BeanDefinition {
    private Class beanClass;

    public BeanDefinition(Class beanCass) {
        this.beanClass = beanCass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanCass) {
        this.beanClass = beanCass;
    }


}
