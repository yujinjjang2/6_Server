package edu.kh.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login") // 현재 클래스를 Servlet 등록 + /login 요청을 처리
public class LoginController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// POST 방식 문제점 : 한글이 깨진다(인코딩 불일치 문제)
		req.setCharacterEncoding("UTF-8"); // 요청 데이터 인코딩 변경
		
		// 전달 받은 값(파라미터) 다 얻어와 변수에 저장
		// POST, GET 모두 전달 받은 값은 파라미터!
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		// id/pw가 user01/pass01과 일치하면 "로그인성공"
		// 일치하지 않으면 "아이디 또는 비밀번호 불일치" 출력
		
		String message = null;
		
		if( id.equals("user01") && pw.equals("pass01") ) {
			message = "로그인 성공";
		} else {
			message = "아이디 또는 비밀번호가 일치하지 않습니다";
		}
		
		// Servlet 으로 클라이언트에게 응답할 화면 만들기...
		// -> 작성하기 힘드니까 JSP로 위임
		
		// Request : 요청
		// Dispatcher : 발송자, 필요한 정보를 제공하는자, 역할을 넘긴다..
		
		// RequestDispatcher : 요청 정보, (응답)역할을 넘기는 객체
		
		// ** JSP 경로 작성방법 **
		// -> webapp 폴더 기준으로 경로를 작성
		RequestDispatcher dispatcher
			= req.getRequestDispatcher("/WEB-INF/views/loginResult.jsp");
		
		
			
	}
}
