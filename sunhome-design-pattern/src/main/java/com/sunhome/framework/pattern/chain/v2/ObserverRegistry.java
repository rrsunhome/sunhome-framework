package com.sunhome.framework.pattern.chain.v2;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author : wangqijia
 * create at:  2020/4/21  下午11:18
 */
public class ObserverRegistry {

    private ConcurrentHashMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registry = new ConcurrentHashMap<>();


    public void register(Object observer) {
        Map<Class<?>, Collection<ObserverAction>> matchedObservers = findAllObserverActions(observer);
        for (Map.Entry<Class<?>, Collection<ObserverAction>> entry : matchedObservers.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> observerActions = entry.getValue();
            CopyOnWriteArraySet<ObserverAction> registeredObserverActions = registry.get(eventType);
            if (registeredObserverActions == null) {
                registry.put(eventType, new CopyOnWriteArraySet<>());
                registeredObserverActions = registry.get(eventType);
            }
            registeredObserverActions.addAll(observerActions);

        }

    }

    public void unregister(Object observer) {
        Map<Class<?>, Collection<ObserverAction>> matchedObservers = findAllObserverActions(observer);
        for (Map.Entry<Class<?>, Collection<ObserverAction>> entry : matchedObservers.entrySet()) {
            Class<?> eventType = entry.getKey();
            CopyOnWriteArraySet<ObserverAction> registeredObserverActions = registry.get(eventType);
            if (registeredObserverActions != null) {
                registry.remove(eventType);
            }
        }

    }

    public List<ObserverAction> getMatchedObservers(Object event) {
        Class<?> postedEventType = event.getClass();

        List<ObserverAction> matchedObservers = new ArrayList<>();
        for (Map.Entry<Class<?>, CopyOnWriteArraySet<ObserverAction>> entry : registry.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> observerActions = entry.getValue();
            if (postedEventType.isAssignableFrom(eventType)) {
                matchedObservers.addAll(observerActions);
            }
        }
        return matchedObservers;
    }

    private Map<Class<?>, Collection<ObserverAction>> findAllObserverActions(Object observer) {

        Map<Class<?>, Collection<ObserverAction>> matchedObservers = new HashMap<>();
        Class<?> clazz = observer.getClass();
        List<Method> matchedMethods = getAnnotatedMethods(clazz);
        for (Method method : matchedMethods) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> eventType = parameterTypes[0];
            matchedObservers.putIfAbsent(eventType, new ArrayList<>());

            matchedObservers.get(eventType).add(new ObserverAction(observer, method));

        }
        return matchedObservers;

    }

    private List<Method> getAnnotatedMethods(Class<?> clazz) {
        List<Method> methods = new ArrayList<>();
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            boolean isAnnotationPresent = method.isAnnotationPresent(Subscribe.class);
            if (isAnnotationPresent) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    methods.add(method);
                }
            }
        }
        return methods;
    }


}
