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

@WebServlet("/noticeOneSelect")
public class SelectOneNoticeController extends HttpServlet{

	SelectNoticeService service = new SelectNoticeService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int noticeNo = Integer.valueOf(req.getParameter("noticeNo"));
			
			List<Notice> notice = service.noticeOneSelect(noticeNo);
			
			for(Notice nt : notice) {
				System.out.println(nt);
			}
			
			req.setAttribute("noticeTitle", notice.get(0).getNoticeTitle());
			req.setAttribute("noticeDetail", notice.get(0).getNoticeDetail());
			req.setAttribute("preTitle", notice.get(0).getPreTitle());
			req.setAttribute("nextTitle", notice.get(0).getNextTitle());
			
			req.getRequestDispatcher("/WEB-INF/views/noticeDetail.jsp").forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
