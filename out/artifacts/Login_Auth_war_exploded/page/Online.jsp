<%--
  Created by IntelliJ IDEA.
  User: 110wz
  Date: 2020/6/5
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="SessionOnline.ListenerSession" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String name= (String)request.getSession().getAttribute("username");
    String pwd=(String)request.getSession().getAttribute("pwd");
    String nums = (String)ListenerSession.getActiveSessions();
%>
<h1>您好！</h1>
<p>用户名:<%=name%><br></p>
<p>密码:<%=pwd%><br></p>
<p>在线人数:<%=nums%></p>
</body>
</html>
