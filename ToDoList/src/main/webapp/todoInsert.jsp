<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>To do 등록하기</title>

	<link rel="stylesheet" href="resources/css/todoIns.css">
</head>
<body>
	<section>
		<h4>To do 등록하기</h4>
		
		<form action="/insert" method="post">
			제목 <br>
			<input type="text" name="title"> <br>
			메모 <br>
			<textarea cols="23" rows="5" name="memo">
			</textarea> <br>
			
			<button type="submit" id="reg-btn">등록하기</button>
		</form>
	</section>
</body>
</html>