<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login</title>
</head>
<body>
	<h1>登录页面</h1>
	<c:forEach items="${users }" var="u">
		<h3>用户ID：${u.id}</h3>
		<h3>用户名：${u.name}</h3>
		<hr/>
		
	</c:forEach>
</body>
</html>