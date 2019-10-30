# Service Provider Interface

## 实现步骤
* 当服务提供者提供了接口的一种具体实现后，在jar包的META-INF/services目录下创建一个以“接口全限定名”为命名的文件，内容为实现类的全限定名；
* 接口实现类所在的jar包放在主程序的classpath中；
* 主程序通过java.util.ServiceLoder动态装载实现模块，它通过扫描META-INF/services目录下的配置文件找到实现类的全限定名，把类加载到JVM；
* SPI的实现类必须携带一个不带参数的构造方法；

## 原理
通过全类名反射创建对象,并存储到集合中


