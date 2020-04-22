package com.sunhome.framework.util;

import java.util.*;

/**
 * @author : wangqijia
 * create at:  2020/4/20  下午11:05
 */
public class CommonServiceLoader {

    public static <S> List<S> loadProvider(Class<S> serviceClass) {
        ServiceLoader<S> servers = ServiceLoader.load(serviceClass);
        Iterator<S> iterator = servers.iterator();

        List<S> candidates = new LinkedList<>();
        while (iterator.hasNext()) {
            S service = iterator.next();
            candidates.add(service);
        }

        Collections.sort(candidates, new OrderComparator<S>());
        return candidates;
    }
}
