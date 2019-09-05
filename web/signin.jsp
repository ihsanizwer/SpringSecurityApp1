<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 9/5/2019
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
</head>
<body>
<h1>Sign In to SpringSecurityApp1</h1>
<form name="signing" action="signin" method="POST" >
<table>
    <tr>
        <td>Username</td><td><input type="text" name="username"></td>
    </tr>
    <tr>
        <td>Password</td><td><input type="password" name="password"></td>
    </tr>
    <tr><td><input type="button" value="submit" name="submit" ></td></tr>
</table>
</form>
</body>
</html>
