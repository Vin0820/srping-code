package cn.vin.srpingframework.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import cn.vin.srpingframework.beans.BeansException;
import cn.vin.srpingframework.beans.PropertyValue;
import cn.vin.srpingframework.beans.factory.config.BeanDefinition;
import cn.vin.srpingframework.beans.factory.config.BeanReference;
import cn.vin.srpingframework.beans.factory.support.AbstractBeanDefinitionReader;
import cn.vin.srpingframework.beans.factory.support.BeanDefinitionRegistry;
import cn.vin.srpingframework.core.io.Resource;
import cn.vin.srpingframework.core.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

public class XmlBeanDefinitionReader  extends AbstractBeanDefinitionReader {
    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try {
            InputStream inputStream = resource.getInputStream();
            doLoadBeanDefinitions(inputStream);

        } catch (IOException | ClassNotFoundException e) {
            throw new BeansException("IOException parsing XML document from"+resource,e);
        }


    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }

    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);

    }

    protected void doLoadBeanDefinitions (InputStream inputStream) throws ClassNotFoundException{

        Document doc = XmlUtil.readXML(inputStream);
        Element root = doc.getDocumentElement();
        NodeList childNodes = root.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            //????????????
            if (!(childNodes.item(i) instanceof Element)){
                continue;
            }
            //????????????
            if (!childNodes.item(i).getNodeName().equals("bean")){
                continue;
            }

            //????????????
            Element bean = (Element)childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");
            //?????? Class,???????????????????????????
            Class<?> clazz = Class.forName(className);
            //?????????id >name
            String beanName=StrUtil.isNotEmpty(id)? id: name;
            if (StrUtil.isEmpty(beanName)){
                beanName=StrUtil.lowerFirst(clazz.getSimpleName());
            }

            //??????bean
            BeanDefinition beanDefinition = new BeanDefinition(clazz);

            //??????bean??????
            for (int j = 0; j <bean.getChildNodes().getLength() ; j++) {
                if (!(bean.getChildNodes().item(j) instanceof  Element)){
                    continue;
                }
                if (!"property".equals(bean.getChildNodes().item(j).getNodeName())){
                    continue;
                }

                //???????????????property

                Element property= (Element)bean.getChildNodes().item(j);
                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");

                //??????????????????????????????????????????
               Object value= StrUtil.isNotEmpty(attrRef)?new BeanReference(attrRef) : attrValue;
               //??????????????????
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);


            }

            if (getRegistry().containsBeanDefintion(beanName)){
                throw new BeansException("Duplicate beanName["+beanName+"] is not allowed");
            }
            //??????BeanDefinition
            getRegistry().registerBeanDefinition(beanName,beanDefinition);


        }

    }
}
