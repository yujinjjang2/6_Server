package edu.kh.todo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.todo.model.service.TodoService;

@WebServlet("/update")
public class UpdateController extends HttpServlet{

	TodoService service = new TodoService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		try {
			
			String todoNo = req.getParameter("todoNo");
			String title = req.getParameter("title");
			String memo = req.getParameter("memo");
			
			int result = service.updateTodo(todoNo, title, memo);
			
			if(result > 0) {
				System.out.println("to do 수정 성공");
				req.getRequestDispatcher("/WEB-INF/views/updateResult.jsp").forward(req, resp);
				
			} else {
				System.out.println("to do 수정 실패");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
