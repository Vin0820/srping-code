package cn.vin.srpingframework;

/**该类只定义了对象的属性
 * @author clustertech
 */
public class BeanDefinition {

    private Object bean;


    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
