<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>scope 생명주기 확인</title>
</head>
<body>
	<h3>page : ${pageScope.str}</h3> <!-- 값X -->
	
	<h3>request : ${requestScope.str}</h3> <!-- 값X -->
	
	<h3>session : ${sessionScope.str}</h3> <!-- session 범위에 세팅된 문자열 -->
	
	<h3>application : ${applicationScope.str}</h3> <!-- application 범위에 세팅된 문자열 -->
	
	<!-- 흐름 : 1) index.html - 2) ScopeController.java(Servlet) - 3) scope.jsp - 
	4) ScopeCheckController(Servlet) - 5) scopeCheck.jsp 
	
	2) req.setAttribute("str", "req로 만들어진..")
	   session.
	   application.
	   
	3) pageContext.setAtt... = 여기서 생성되고, 죽음.
	-->
</body>
</html>