<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>투 두 리스트 로그인</title>

    <link rel="stylesheet" href="../resources/css/main.css">
</head>
<body>
    <section>
        <div>
            <h4>투 두 리스트 로그인</h4>
        </div>

        <div>
            <form action="/login" method="post" id="form">
                아이디 <br>
                <input type="text" name="id"> <br>
                패스워드 <br>
                <input type="password" name="pw"> <br>

                <button type="submit" id="login-btn">로그인</button> <br>
                <a href="./signReg.jsp">회원가입</a>
            </form>
        </div>
    </section>
</body>
</html>