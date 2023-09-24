<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>투 두 리스트 회원가입</title>

    <link rel="stylesheet" href="../resources/css/sign.css">
</head>
<body>
    <section>
        <div>
            <h4>회원가입</h4>
        </div>

        <div>
            <form action="/signup" method="post" id="form">
                아이디 <br>
                <input type="text" name="id" id="id"> <br>
                <span id="id-span">영어 대/소문자, 숫자, 특수문자 포함 6~14글자</span> <br><br>
                비밀번호 <br>
                <input type="password" name="pw" id="pw"> <br>
                비밀번호 확인<br>
                <input type="password" name="pw2" id="pw2"> <br>
                <span id="pw2-span"></span> <br>
                닉네임 <br>
                <input type="text" name="nm" id="nm"> <br>
                <span id="nm-span"></span>

                <button type="submit" id="sign-btn">가입하기</button> <br>
            </form>
        </div>
    </section>

    <script src="resources/js/signup.js"></script>
</body>
</html>