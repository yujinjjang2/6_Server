package edu.kh.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.member.model.dto.Member;
import edu.kh.member.model.service.MemberService;
import edu.kh.todo.model.dto.Todo;
import edu.kh.todo.model.service.TodoService;

@WebServlet("/login")
public class LoginController extends HttpServlet{
	
	MemberService service = new MemberService();
	TodoService service2 = new TodoService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			HttpSession session = req.getSession();
			
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			
			List<Member> member = service.selectMember(id, pw);
			
			for(Member mem : member) {
				System.out.println(mem);
			}
			
			if(member.size() == 1) {
				System.out.println("로그인 성공");
				
				int memNo = member.get(0).getMemberNo();
				
				session.setAttribute("memNo", memNo);
				session.setAttribute("nickName", member.get(0).getMemberNickname());
				
				List<Todo> todo = service2.selectTodo(memNo);
				
				for(Todo td : todo) {
					System.out.println(td);
				}

				req.setAttribute("nickName", member.get(0).getMemberNickname());
				req.setAttribute("todo", todo);
				req.getRequestDispatcher("/WEB-INF/views/todo.jsp").forward(req, resp);
				
			} else {
				System.out.println("로그인 실패");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
