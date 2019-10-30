<%@ page contentType="text/html; charset=UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page import="java.util.*" %>


<c:forEach items="${books}"/>

<%
    out.println("业务调用结束的时间：" + new java.util.Date());
    if (request.isAsyncStarted()) {
        // 完成异步调用
        request.getAsyncContext().complete();
    }
%>