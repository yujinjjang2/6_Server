package edu.kh.todo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.todo.model.service.TodoService;

@WebServlet("/insert")
public class InsertController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		TodoService service = new TodoService();
		
		HttpSession session = req.getSession();
		
		req.setCharacterEncoding("UTF-8");
		
		try {
			
			String title = req.getParameter("title");
			String memo = req.getParameter("memo");
			int memberNo = (int) session.getAttribute("memberNo");
			
			int result = service.insertTodo(title, memo, memberNo);
			
			if(result > 0) {
				System.out.println("to do 등록 성공");
				req.getRequestDispatcher("/WEB-INF/views/insert.jsp").forward(req, resp);
			} else {
				System.out.println("to do 등록 실패");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
