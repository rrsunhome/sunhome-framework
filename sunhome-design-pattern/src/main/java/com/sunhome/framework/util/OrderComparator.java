package com.sunhome.framework.util;

import java.util.Comparator;
import java.util.Objects;

/**
 * @author : wangqijia
 * create at:  2020/4/21  下午10:35
 */
public class OrderComparator<T> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        int prevOrder = getOrder(o1);
        int nextOrder = getOrder(o2);
        return nextOrder - prevOrder;
    }

    /**
     * 获取排序大小，优先获取注解
     *
     * @param o
     * @return
     */
    public int getOrder(T o) {
        Order order = o.getClass().getAnnotation(Order.class);
        if (Objects.nonNull(order)) {
            return order.value();
        }
        boolean isAssignOrder = Ordered.class.isAssignableFrom(o.getClass());
        if (isAssignOrder) {
            Ordered ordered = (Ordered) o;
            return ordered.getOrder();
        }
        return 0;
    }
}
