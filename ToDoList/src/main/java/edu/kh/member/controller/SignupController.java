package edu.kh.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.member.model.dto.Member;
import edu.kh.member.model.service.MemberService;

@WebServlet("/signup")
public class SignupController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MemberService service = new MemberService();
		
		try {
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			String nm = req.getParameter("nm");
			
			int result = service.insertMember(id, pw, nm);
			
			if(result > 0) {
				System.out.println("회원가입 성공");
				req.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(req, resp);
			} else {
				System.out.println("회원가입 실패");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
