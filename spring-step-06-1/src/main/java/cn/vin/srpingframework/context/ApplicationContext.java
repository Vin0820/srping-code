package cn.vin.srpingframework.context;


import cn.hutool.core.bean.BeanException;
import cn.vin.srpingframework.beans.factory.ListableBeanFactory;

/**
 *
 * @author clustertech，继承于ListableBeanFactory，也就继承了 继承了关于BeanFactory
 * 方法，比如一些getBean的方法。另外ApplicationContext 本身是central接口，
 * 但目前还不需要添加一些获取id和父类的上下文，所以暂时没有接口方法的定义。
 * ApplicationContext
 */

public interface ApplicationContext extends ListableBeanFactory {


//    /**
//     * 刷新容器
//     * @throws BeanException
//     */
//    void refresh()throws BeanException;
}
