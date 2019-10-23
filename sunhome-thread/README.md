<br>

# 多线程的出现引发了哪些问题？
1. cpu 多核的出现引发了缓存可见性问题
2. 多线程的出现和线程的上下文切换引发了原子性问题
3. 编译优化带来的有序性问题

## 线程模块(详情见每一章的demo)
* chapter1 线程的基本使用
    1. currentThread()、join()、yield()、interrupt()方法的使用
* chapter2 synchronized锁的使用
    1. 修饰普通方法时对象锁
    2. 修饰静态方法时class锁
    3. volatile修饰变量保证可见性
    4. atomic原子类的使用
* chapter3 等待/唤醒机制掌握
    1. wait()、notify()、ThreadLocal使用
    2. join()等待线程完成同时释放锁资源
    3. sleep()进入等待队列，不释放锁
* chapter4 lock的使用
    1. ReentrantLock类的使用
    2. ReentrantReadWriteLock的使用
* chapter5 timer 的使用
    1. schedule()使用 ，单线程下while循环做调度任务
* chapter6 线程不安全的场景
    1. 共享变量的使用
    2. 无法保证原子性的方法
    

    
### 常见线程不安全类
SimpleDateFormat 共享对象多线程访问 （1）（2）（3）无法保证原子性,导致Calendar对象构建有问题

    Calendar establish(Calendar cal) {
       (1）重置日期对象cal的属性值
       cal.clear();
       (2) 使用calb中中属性设置cal
       (3)返回设置好的cal对象
       return cal;




    
     


    

