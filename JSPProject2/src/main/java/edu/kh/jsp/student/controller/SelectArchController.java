package edu.kh.jsp.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.jsp.student.model.dto.Student;
import edu.kh.jsp.student.model.service.StudentService;

@WebServlet("/jstl/student/selectArch")
public class SelectArchController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentService service = new StudentService();
		
		try {
			List<Student> stdList = service.selectArch();
			
			req.setAttribute("stdList", stdList);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		req.getRequestDispatcher("/WEB-INF/views/student/selectArch.jsp").forward(req, resp);
	}

}
