package edu.kh.todo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.todo.model.dto.Todo;
import edu.kh.todo.model.service.TodoService;

@WebServlet("/selectTodo")
public class SelectController extends HttpServlet{
	
	TodoService service = new TodoService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		try {
			
			HttpSession session = req.getSession();
			
			int memNo = (int) session.getAttribute("memNo");
			String nickName = (String) session.getAttribute("nickName");
			
			List<Todo> todo = service.selectTodo(memNo); 
			
			for(Todo td : todo) {
				System.out.println(td);
			}

			req.setAttribute("nickName", nickName);
			req.setAttribute("todo", todo);
			req.getRequestDispatcher("/WEB-INF/views/todo.jsp").forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
