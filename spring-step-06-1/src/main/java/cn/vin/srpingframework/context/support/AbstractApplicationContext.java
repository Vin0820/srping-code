package cn.vin.srpingframework.context.support;

import cn.vin.srpingframework.beans.BeansException;
import cn.vin.srpingframework.beans.factory.ConfigurableListableBeanFactory;
import cn.vin.srpingframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.vin.srpingframework.beans.factory.config.BeanPostProcessor;
import cn.vin.srpingframework.context.ConfigurableApplicationContext;
import cn.vin.srpingframework.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 *
 * @author clustertech
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {


    @Override
    public void refresh() throws BeansException {

        //1、创建 BeanFactory ,并加载 BeanDefinition

        refreshBeanFactory();

        //2.获取BeanFactory
      ConfigurableListableBeanFactory beanFactory=   getBeanFactory();


      //3、在Bean实例化之前，执行BeanFactoryPostProcess
        invokeBeanFactoryPostProcess(beanFactory);


        //4、BeanPostProcessor需要提前于其他Bean 对象实例化之前执行注册操作

        registerBeanPostProcessors(beanFactory);




        //5、提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();






    }


    private  void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory){


        Map<String, BeanPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);

        for (BeanPostProcessor beanPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);

        }


    }

    protected abstract void refreshBeanFactory()throws BeansException;


    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    private void invokeBeanFactoryPostProcess(ConfigurableListableBeanFactory beanFactory){

          Map<String,BeanFactoryPostProcessor> beanFactoryPostProcessorMap= beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);


        }



    }
}
