package cn.vin.srpingframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author clustertech
 */
public interface Resource {


    InputStream getInputStream() throws IOException;


}
