<%@page import="edu.kh.jsp.model.dto.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Servlet/JSP 내장 객체와 범위</title>
</head>
<body>
	<h1>Servlet/JSP 내장 객체와 범위</h1>
	
	<pre>
		Servlet/JSP에는 4종류의 범위를 갖는 내장 객체 존재
		-> 각 종류마다 영향을 끼치는 범위가 다름
		-> 개발자가 객체를 별도 생성하지 않아도 JSP에서 바로 사용할 수 있는 객체
		
		
		1. page : 현재 페이지(한 페이지)
			-> 현재 JSP에서만 사용 가능
			
		
		2. request : '요청 받은 페이지와
					이를 위임 받은 페이지'에서 사용 가능	 
		 		
		3. session : 현재 사이트에 접속한 브라우저 당 1개씩 생성
					브라우저가 종료되거나, session 만료될때 까지 유효
					
					
		4. application : 하나의 웹 애플리케이션마다 1개씩 생성되는 객체
						서버 켜질때 생성되어 종료될때 없어짐
						
						
						
		***************************
		** 내장 객체의 우선 순위 **
		***************************
		
		
		page > request > session > application				
		
	</pre>
	
	<ul>
		<li>
			page scope <br>
			
			<%
				// pageContext : page scope 객체
				pageContext.setAttribute("pageValue", 555);
			
				pageContext.setAttribute("str", "page 범위에 세팅된 문자열");
			%>
			
			pageValue : ${pageScope.pageValue} <!-- 555 -->
		</li>
		
		<br>
		
		<li>
			request scope <br>
			reqValue : ${requestScope.reqValue} <!-- 1234 -->
		</li>
		
		<br>
		
		<li>
			session scope <br>
			sessionValue : ${sessionScope.sessionValue} <!-- 999 -->
		</li>
		
		<br>
		
		<li>
			application scope <br>
			appValue : ${applicationScope.appValue} <!-- 10000 -->
		</li>
	</ul>
	
	
	
	<hr>
	
	<h3>
		<a href="scopeCheck">내장 객체별 생명주기 확인</a>
	</h3>
	
	
	<hr>
	
	<h3>우선 순위 확인</h3>
	
	<h4>각각의 범위에 세팅된 str</h4>
	${pageScope.str} <br>
	${requestScope.str} <br>
	${sessionScope.str} <br>
	${applicationScope.str} <br>
	
	<h4>${str}</h4>
	<%-- 우선순위에 의해 가장 우선순위가 높은 page 가 나온다 --%>
	
</body>
</html>