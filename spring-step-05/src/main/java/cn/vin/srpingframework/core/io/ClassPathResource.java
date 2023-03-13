package cn.vin.srpingframework.core.io;


import cn.hutool.core.lang.Assert;
import cn.vin.srpingframework.until.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 主要是用于处理资源加载流
 * 三种方式 classPath、FileSystem、URL
 * @author clustertech
 */
public class ClassPathResource  implements Resource{

    private final String path;

    private  ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path,(ClassLoader)null);
    }
    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
    }



    @Override
    public InputStream getInputStream() throws IOException {
        InputStream resourceAsStream = classLoader.getResourceAsStream(path);
        if (resourceAsStream==null){
            throw new FileNotFoundException(this.path+"cannot be opened because it does not exist");
        }
        return null;
    }
}
