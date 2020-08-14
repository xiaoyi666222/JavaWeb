<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--^^^^^添加对jstl列表的支持^^^^^--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>listBooks</title>
</head>
<body>

<form id="saveForm" action="${pageContext.request.contextPath}/a/login" method="post">
    <table align="center" bgcolor="aqua" border="1" cellpadding="0">
        <tr>
            <th width="140">用户名</th>
            <th width="140">密码</th>
        </tr>
        <tr>
            <td width="140"><input type="text" value="${User.username}" name="username"/></td>
            <td width="140"><input type="text" value="${User.password}" name="password"/></td>
            <td width="140"><input type="submit" value="登录" /></td>
        </tr>
    </table>
</form>
</body>
</html>
