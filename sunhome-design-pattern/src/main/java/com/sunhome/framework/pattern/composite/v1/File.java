package com.sunhome.framework.pattern.composite.v1;

/**
 * @author : wangqijia
 * create at:  2020/4/20  下午4:41
 */
public class File extends FileNode {

    public File(String path) {
        super(path);
    }

    @Override
    public int countNum() {
        return 1;
    }

    @Override
    public long countSize() {
        java.io.File file = new java.io.File(path);
        if (!file.exists()) {
            return 0;
        }
        return file.length();
    }
}
