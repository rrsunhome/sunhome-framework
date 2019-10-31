## 登录模块

## 目的-可插性支持
  可以在不修改已有 Web 应用的前提下，只需将按照一定格式打成的 JAR 包放到 WEB-INF/lib 目录下，即可实现新功能的扩充，不需要额外的配置。
 
## 实现步骤
* 使用servlet3.0 @WebServlet,@WebFilter,@WebServlet 注解声明到类上
*  META-INF 目录下放置一个 web-fragment.xml 文件，该文件和web.xml规则一致

```xml
<?xml version="1.0" encoding="UTF-8"?>
    <web-fragment
        xmlns=http://java.sun.com/xml/ns/javaee
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" version="3.0"
        xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
        http://java.sun.com/xml/ns/javaee/web-fragment_3_0.xsd"
        metadata-complete="true">
        <servlet>
            <servlet-name>fragment</servlet-name>
            <servlet-class>footmark.servlet.FragmentServlet</servlet-class>
        </servlet>
        <servlet-mapping>
            <servlet-name>fragment</servlet-name>
            <url-pattern>/fragment</url-pattern>
        </servlet-mapping>
    </web-fragment>
```

该模块仅实现第一种

    
    

