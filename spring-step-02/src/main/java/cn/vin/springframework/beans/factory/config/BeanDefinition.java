package cn.vin.springframework.beans.factory.config;

/**
 * @author clustertech
 */
public class BeanDefinition {
    private Class beanCass;

    public BeanDefinition(Class beanCass) {
        this.beanCass = beanCass;
    }

    public Class getBeanCass() {
        return beanCass;
    }

    public void setBeanCass(Class beanCass) {
        this.beanCass = beanCass;
    }


}
