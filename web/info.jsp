<%--
  Created by IntelliJ IDEA.
  User: 86132
  Date: 2022/11/25
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>员工表信息</title>
    <script>
        function shwo1() {
            var st = window.confirm("是否要删除数据");
            if(st){
                return true;
            }else {
                return false;
            }

        }
    </script>
</head>
<body>
<table border="1px solid" align="center" >
    <tr align="center">
        <td>员工编号</td>&nbsp;&nbsp;
        <td>员工姓名</td>&nbsp;&nbsp;
        <td>工作岗位</td>&nbsp;&nbsp;
        <td>经理编号</td>&nbsp;&nbsp;
        <td>入职时间</td>&nbsp;&nbsp;
        <td>工作薪资</td>&nbsp;&nbsp;
        <td>工作奖金</td>&nbsp;&nbsp;
        <td>部门编号</td>&nbsp;&nbsp;
        <td>操作</td>

    </tr>
<c:forEach items="${sessionScope.sr}" var="emp">
    <tr align="center">
        <td>${emp.empno}</td>&nbsp;&nbsp;
        <td>${emp.ename}</td>&nbsp;&nbsp;
        <td>${emp.job}</td>&nbsp;&nbsp;
        <td>${emp.mgr}</td>&nbsp;&nbsp;
        <td>${emp.hiredate}</td>&nbsp;&nbsp;
        <td>${emp.sal}</td>&nbsp;&nbsp;
        <td>${emp.comm}</td>&nbsp;&nbsp;
        <td>${emp.deptno}</td>&nbsp;&nbsp;
        <td><a href="emp?i=5&empno=${emp.empno}" onclick="return shwo1();">删除</a></td>
        <td ><a href="emp?i=6&empno=${emp.empno}" >修改</a></td>

    </tr>


</c:forEach>

</table>

</body>
</html>
