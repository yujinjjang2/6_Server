<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>To do 수정하기</title>

	<link rel="stylesheet" href="resources/css/todoIns.css">
</head>
<body>
	<section>
		<h4>To do 수정하기</h4>
		
		<form action="/update" method="post">
			제목 <br>
			<input type="text" name="title" value=${todo[0].todoTitle} > <br>
			메모 <br>
			<textarea cols="23" rows="5" name="memo">${todo[0].todoMemo}
			</textarea> <br>
			<input type="hidden" name="todoNo" value=${todo[0].todoNo}>
			<button type="submit" id="reg-btn">등록하기</button>
		</form>
	</section>
</body>
</html>