<%--
  Created by IntelliJ IDEA.
  User: 86132
  Date: 2022/11/25
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改</title>
    <script>
        function who() {
            var w = window.confirm("是否要修改该数据");
            if(w){
                return true;
            }else {}
            return false;

        }
    </script>
</head>
<body>
<form action="emp" method="post">
<c:forEach items="${sessionScope.ss}" var="emp">
    员工编号： <input type="text" name="empno" readonly="readonly" value="${emp.empno}"><br>
    员工姓名：<input type="text" name="ename" value="${emp.ename}"><br>
    岗位职业：<input type="text" name="job" value="${emp.job}"><br>
    经理编号：<input type="text" name="mgr" value="${emp.mgr}"><br>
    入职日期：<input type="date" name="hiredate" value="${emp.hiredate}"><br>
    员工薪资：<input type="text" name="sal" value="${emp.sal}"><br>
    员工奖金：<input type="text" name="comm" value="${emp.comm}"><br>
    部门编号：<input type="text" name="deptno" value="${emp.deptno}"><br>
    <input type="hidden" name="i" value="7">
    <input type="submit" onclick="who();" value="修改">
</c:forEach>
</form>
</body>
</html>
