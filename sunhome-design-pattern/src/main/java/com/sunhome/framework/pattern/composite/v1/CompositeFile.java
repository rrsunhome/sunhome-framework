package com.sunhome.framework.pattern.composite.v1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : wangqijia
 * create at:  2020/4/20  下午4:42
 */
public class CompositeFile extends FileNode {

    private List<FileNode> fileNodes = new ArrayList<>();

    public CompositeFile(String path) {
        super(path);
    }

    public void addSubNode(FileNode fileNode) {
        fileNodes.add(fileNode);
    }

    @Override
    public int countNum() {
        int countNum = 0;
        for (FileNode fileNode : fileNodes) {
            countNum += fileNode.countNum();
        }
        return countNum;
    }

    @Override
    public long countSize() {
        long countSize = 0;

        for (FileNode fileNode : fileNodes) {
            countSize += fileNode.countSize();
        }
        return countSize;
    }

    public void remove(FileNode fileNode) {
        int size = fileNodes.size();
        int i = 0;
        for (; i < size; i++) {
            boolean isEq = fileNodes.get(i).getPath().equalsIgnoreCase(fileNode.getPath());
            if (isEq) {
                break;
            }
        }

        fileNodes.remove(i);
    }
}
