package cn.vin.srpingframework.beans.factory.config;


import cn.vin.srpingframework.beans.PropertyValues;

/**
 * @author clustertech
 */
public class BeanDefinition {
    private Class beanClass;
    private PropertyValues propertyValues;

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues =  propertyValues!= null ? propertyValues : new PropertyValues();;
    }
    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

}
