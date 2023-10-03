package notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.dto.Notice;
import notice.model.service.SelectNoticeService;

@WebServlet("/selectNotice")
public class SelectNoticeController extends HttpServlet{

	SelectNoticeService service = new SelectNoticeService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			List<Notice> list = service.selectNotice();
			
			for(Notice li : list) {
				System.out.println(li);
			}
			
			req.setAttribute("list", list);
			
			req.getRequestDispatcher("/WEB-INF/views/noticeList.jsp").forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
