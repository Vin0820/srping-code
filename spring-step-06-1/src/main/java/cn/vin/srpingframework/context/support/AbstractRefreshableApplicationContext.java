package cn.vin.srpingframework.context.support;

import cn.vin.srpingframework.beans.BeansException;
import cn.vin.srpingframework.beans.factory.ConfigurableListableBeanFactory;
import cn.vin.srpingframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author clustertech
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;


    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory=beanFactory;

    }

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }


    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }



    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);






}