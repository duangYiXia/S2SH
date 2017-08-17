<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>My JSP 'register.jsp' starting page</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>

<body>
	<s:form action="loginAction/saveUesr.do">
		<s:textfield name="username" label="用户名" />
		<s:password name="password" label="密码" />
		<s:submit value="注册" />
	</s:form>

</body>
</html>
