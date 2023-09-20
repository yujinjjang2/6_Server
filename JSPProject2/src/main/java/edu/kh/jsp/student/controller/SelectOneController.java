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

@WebServlet("/jstl/student/selectOne")
public class SelectOneController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("UTF-8");
		
		StudentService service = new StudentService();
		
		try {
			String deptName = req.getParameter("deptName"); // 입력한 과
			
			// 학과 맞는 학생 조회 서비스
			List<Student> stdList = service.selectOne(deptName);
			
			// request scope에 stdList를 담아서 JSP 로 위임
			req.setAttribute("stdList", stdList);
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// 요청 위임
		req.getRequestDispatcher("/WEB-INF/views/student/selectOne.jsp").forward(req, resp);
		
	}
}
