<br>

### 多线程的出现引发了哪些问题？
1. cpu 多核的出现引发了缓存可见性问题
2. 多线程的出现和线程的上下文切换引发了原子性问题
3. 编译优化带来的有序性问题

> 线程模块(详情见每一章的demo)
* chapter1 线程的基本使用
    1. currentThread()、join()、yield()、interrupt()方法的使用
* chapter2 synchronized锁的使用
    1. 修饰普通方法时对象锁
    2. 修饰静态方法时class锁
    3. volatile修饰变量保证可见性
    4. atomic原子类的使用
    
* chapter3 等待/唤醒机制掌握
    1. wait()、notify()、ThreadLocal使用

    
     


    

