package edu.kh.todo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.todo.model.service.TodoService;

@WebServlet("/todoDelete")
public class DeleteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		TodoService service = new TodoService();
		HttpSession session = req.getSession();
		
		req.setCharacterEncoding("UTF-8");
		
		try {
			int todoNo 		= Integer.valueOf(req.getParameter("todoNo"));
			
			int result = service.deleteTodo(todoNo);
			
			if(result > 0) {
				System.out.println("to do 삭제 성공");
				req.getRequestDispatcher("/WEB-INF/views/delete.jsp").forward(req, resp);
			} else {
				System.out.println("to do 삭제 실패");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
