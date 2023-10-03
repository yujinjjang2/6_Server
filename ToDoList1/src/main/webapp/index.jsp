<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>투 두 리스트 로그인</title>

	<link rel="stylesheet" href="resources/css/main.css">
</head>
<body>
	<section>
		<div>
			<h3>투 두 리스트 로그인</h3>
		</div>
		<div>
			<form action="/login" method="post">
				아이디 <br>
				<input type="text" name="id" id="id"> <br><br>
				패스워드 <br>
				<input type="password" name="pw" id="pw"> <br><br>

				<button type="submit" id="login-btn">로그인</button>
			</form>

			<a href="signReg.jsp">회원가입</a>
		</div>
	</section>
</body>
</html>