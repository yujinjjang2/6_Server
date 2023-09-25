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
import edu.kh.todo.model.dto.Todo;
import edu.kh.todo.model.service.TodoService;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MemberService service = new MemberService();
		TodoService service2 = new TodoService();
		
		try {
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			
			List<Member> member = service.selectLogin(id, pw);
			
			for(Member mem : member) {
				System.out.println(mem);
			}
			
			// 로그인 성공할 경우 todoList 가져오기
			if(member.size() == 1) {
				int memNo = member.get(0).getMemberNo();
				
				List<Todo> todo = service2.selectTodo(memNo);
				
				for(Todo td : todo) {
					System.out.println(td);
				}
				
				req.setAttribute("todo", todo);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			
		}
		
		req.getRequestDispatcher("/WEB-INF/views/todo.jsp").forward(req, resp);
		
	}
}
