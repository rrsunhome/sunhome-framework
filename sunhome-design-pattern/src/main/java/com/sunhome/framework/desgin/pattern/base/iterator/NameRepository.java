package com.sunhome.framework.desgin.pattern.base.iterator;

/**
 * @author lizongren
 * @date 2019.11.22 12:46
 */
public class NameRepository implements Container {
    public  String[] names={"德莱厄斯","诺克萨斯","雷恩加尔","奥利安娜","马尔扎哈","莫德凯撒"};
    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }
    private class  NameIterator implements  Iterator{
        int index;
        @Override
        public boolean hasNext() {
            if (index<names.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (hasNext()){
                return names[index++];
            }
            return null;
        }
    }
}
