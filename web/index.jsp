<%--
  Created by IntelliJ IDEA.
  User: 86132
  Date: 2022/11/25
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>

    <script>
      function  show() {

        window.location.href="register.jsp?backurl="+window.location.href;
      }
    </script>
  </head>
  <body>
  <form action="emp" method="post">
    员工编号：<input type="text" name="empno"><br>
    员工姓名：<input type="text" name="uname"><br>
    <input type="hidden" name="i" value="2">
    <input type="submit" value="登录">
    <input type="button" value="注册" onclick="show();">
  </form>
  </body>
</html>
