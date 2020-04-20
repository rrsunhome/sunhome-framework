package com.sunhome.framework.pattern.composite.v1;

/**
 * @author : wangqijia
 * create at:  2020/4/20  下午4:38
 */
public abstract class FileNode {

    protected String path;

    public FileNode(String path) {
        this.path = path;
    }

    public abstract int countNum();

    public abstract long countSize();

    public String getPath() {
        return path;
    }
}
