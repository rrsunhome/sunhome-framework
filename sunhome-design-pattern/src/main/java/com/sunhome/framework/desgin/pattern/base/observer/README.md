# java-设计模式-观察者模式

当对象间存在一对多关系时 使用观察者模式(Observer Pattern) 比如 当一个对象被修改时 则会自动通知它的依赖对象 属于行为型模式

意图: 定义对象间的一种一对多的依赖关系 当一个对象的状态发生改变时 所有依赖于它的对象都得到通知 并自动更新

主要解决: 一个对象状态改变给其他对象通知的问题 

关键代码: 在抽象类里有一个ArrayList来存放观察者 当目标对象set时 遍历update所有Observer

具体被观察者(主题)subject类 抽象观察者Observer类 具体观察者 FirstObserver SecondObserver


    
    
