<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>투 두 리스트 목록</title>

	<link rel="stylesheet" href="../../resources/css/todo.css">
		
	<script type="text/javascript">
    	function todoUpdate(todoNo) {
    		location.href = "/todoOneSelect?todoNo="+todoNo;
    	}

    	function todoDelete(todoNo) {
    		location.href = "/todoOneDelete?todoNo="+todoNo;
    	}
	</script>
</head>
<body>
	<section>
		<h3>${nickName}의 투 두 리스트</h3>
		
		<table id="table">
			<tr>
				<td width="100px" style="font-weight: bold;">제목</td>
				<td width="300px" style="font-weight: bold;">내용</td>
				<td width="200px" style="font-weight: bold;">등록일자</td>
				<td width="80px"></td>
				<td width="80px"></td>
			</tr>
			
			<c:forEach var="todo" items="${todo}" varStatus="vs">
				<tr>
					<td>${todo.todoTitle}</td>
					
					<td>${todo.todoMemo}</td>
					
					<td>${todo.todoDate}</td>
					
					<td><button type="button" id="up-btn" onclick="todoUpdate(${todo.todoNo})">수정</button></td>
					<td><button type="button" id="del-btn" onclick="todoDelete(${todo.todoNo})">삭제</button></td>
				</tr>
			</c:forEach>
		</table>

		<div>
			<a href="todoReg.jsp"><button type="button" id="reg-btn">등록하기</button></a>
			<a href="/"><button type="button" id="logout-btn">로그아웃</button></a>
		</div>	
	</section>
</body>
</html>