<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>투 두 리스트 조회</title>
	
	<style>
		table {
			border-collapse: collapse;
		}
	</style>
</head>
<body>
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
				
				<td><button>수정</button></td>
				
				<td><button>삭제</button></td>
			</tr>
		</c:forEach>
		
		
	</table>
</body>
</html>