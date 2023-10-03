package edu.kh.todo.controller;

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

@WebServlet("/todoSelect")
public class SelectController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		TodoService service = new TodoService();
		HttpSession session = req.getSession();
		
		req.setCharacterEncoding("UTF-8");
		
		try {
			int todoNo = Integer.valueOf(req.getParameter("todoNo"));
			
			List<Todo> todo = service.selectTodoOne(todoNo);
			
			for(Todo td : todo) {
				System.out.println(td);
			}
			
			req.setAttribute("todo", todo);
			
		} catch(Exception e) {
			e.printStackTrace();
			
		}
		
		req.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(req, resp);
		
	}
}
