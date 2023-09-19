<%@page import="edu.kh.jsp.model.dto.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>EL 결과</title>
</head>
<body>
	<h1>EL을 이용해서 출력하기</h1>
	
	<h3>파라미터</h3>
	<ul>
		<li> \${ param.name속성값 } : request 담긴 파라미터 얻어오기 (1개) </li>
		<li> \${ paramValues } : 모든 파라미터를 배열로 얻어오기 </li>
		<li> \${ paramValues.name속성값[인덱스] } :
			name이 일치하는 파라미터 중 지정된 인덱스번째 value
		</li>
	</ul>
	
	<p>
		이름 : ${param.inputName} <br>
		나이 : ${param.inputAge} <br>
		
		opt : ${param.opt} <br> <!-- 0번째 인덱스만 나옴 -->
		
		opt[0] : ${paramValues.opt[0]} <br>
		opt[1] : ${paramValues.opt[1]} <br>
		opt[2] : ${paramValues.opt[2]} <br>
	</p>
	
	<hr>
	
	<h3>세팅된 속성(attribute) 출력하기</h3>
	
	<ul>
		<li>기본 : \${ key }    (key는 세팅한 속성의 key값)</li>
		
		<li>배열 또는 List : \${ key[index] }</li>
		
		<li>DTO 또는 Map : \${ key.필드명 }</li>
	</ul>
	
	
	<p>
		address(JSP) : <%= request.getAttribute("address") %> <br> <%-- 서울시 중구 남대문로 120 --%>
		address(EL)  : ${address} <br> <%-- 서울시 중구 남대문로 120 --%>
		
		score : ${score} <br> <%-- 100 --%>
		strList : ${strList} <br> <%-- [가가가,나나나,다다다] --%>
		book : ${book} <br> <%-- edu.kh.jsp.model.dto.Book@3ce4a2cc --%>
		
		<br><br>
		
		strList[0] : ${strList[0]} <br> <%-- 가가가 --%>
		strList[1] : ${strList[1]} <br> <%-- 나나나 --%>
		strList[2] : ${strList[2]} <br> <%-- 다다다 --%>
		
		<br><br>
		
		<%-- <%= ((Book)request.getAttribute("book")).getTitle() %> --%>
		
		book의 title : ${book.title} <br> <%-- 어린왕자 --%>
		book의 writer : ${book.writer} <br> <%-- 생택쥐베리 --%>
		book의 price : ${book.price} <br> <%-- 4000 --%>
	</p>
	
	
	<hr>
	
	<h1>EL은 null, 비어있다를 같은 것으로 생각한다!</h1>
	
	${list1}  /  ${list2}
	
	<h4>empty 연산자</h4> <!-- 자주 사용! -->
	
	${empty list1}  /  ${empty list2}
	
	<%-- true        /     true --%>
	
	
</body>
</html>