<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<meta charset="UTF-8">
	<title>투 두 리스트 조회</title>
	
	<style>
		table {
			border-collapse: collapse;
			border: none;
		}
	</style>

	<link rel="stylesheet" href="../../resources/css/todo.css">
</head>
<body>
	<section>
		<h1>투 두 리스트 조회</h1>
		
		<table border="1">
			<!-- table header -->
			<tr>
				<th>타이틀</th>
				<th>내용</th>
				<th>등록일</th>
				<th></th>
				<th></th>
			</tr>
			
			<c:forEach var="todo" items="${todo}" varStatus="vs">
				<tr>
					<td>${todo.memberTitle}</td>
					
					<td>${todo.todoMemo}</td>
					
					<td>${todo.todoDate}</td>
					
					<td><button id="update-btn">수정</button></td>
					
					<td><button id="delete-btn">삭제</button></td>
				</tr>
			</c:forEach>
			
		</table>

		<div>
			<a href="./todoInsert.jsp"><button id="reg-btn">등록하기</button></a>
			<a href="/"><button id="logout-btn">로그아웃</button></a>
		</div>

	</section>
</body>
</html>