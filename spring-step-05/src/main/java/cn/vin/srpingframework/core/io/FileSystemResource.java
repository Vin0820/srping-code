package cn.vin.srpingframework.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 通过文件路径去获取文件
 * @author clustertech
 */
public class FileSystemResource  implements Resource{


    private final File file;
    private final String path;

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    public FileSystemResource( String path) {
        this.file = new File(path);
        this.path = path;
    }



    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    private final String getPath(){
        return this.path;
    }
}
