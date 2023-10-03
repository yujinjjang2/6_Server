package edu.kh.todo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.todo.model.dto.Todo;
import edu.kh.todo.model.service.TodoService;

@WebServlet("/todoOneSelect")
public class SelectOneController extends HttpServlet{

	TodoService service = new TodoService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String todoNo = req.getParameter("todoNo");
			
			List<Todo> todo = service.selectOne(todoNo);
			
			for(Todo td : todo) {
				System.out.println(td);
			}
			
			req.setAttribute("title", todo.get(0).getTodoTitle());
			req.setAttribute("memo", todo.get(0).getTodoMemo());
			req.setAttribute("todoNo", todo.get(0).getTodoNo());
			req.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
