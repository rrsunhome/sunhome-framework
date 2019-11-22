package com.sunhome.framework.desgin.pattern.base.iterator;

/**
 * @author lizongren
 * @date 2019.11.22 12:57
 */
public class Test {
    public static void main(String[] args) {
        NameRepository nameRepository=new NameRepository();
        for (Iterator iterator=nameRepository.getIterator();iterator.hasNext();){
            System.out.println(iterator.next());
        }
    }
}
