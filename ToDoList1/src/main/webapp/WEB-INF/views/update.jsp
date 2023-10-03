<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>투 두 수정하기</title>

    <link rel="stylesheet" href="resources/css/todoReg.css">
</head>
<body>
    <section>
        <div>
            <h3>To do 수정하기</h3>
        </div>

        <div>
            <form action="/update" method="post">
            	<input type="hidden" name="todoNo" value=${todoNo}>
                제목 <br>
                <input type="text" name="title" id="title" value=${title}> <br><br>

                메모 <br>
                <textarea cols="22" rows="5" id="textarea" name="memo">${memo}</textarea> <br><br>

                <button type="submit" id="upd-btn">수정하기</button>
            </form>
        </div>
    </section>
</body>
</html>