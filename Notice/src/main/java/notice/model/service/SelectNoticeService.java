package notice.model.service;

import java.sql.Connection;
import java.util.List;

import notice.model.dao.SelectNoticeDAO;
import notice.model.dto.Notice;

import static notice.common.JDBCTemplate.*;

public class SelectNoticeService {
	
	SelectNoticeDAO dao = new SelectNoticeDAO();

	public List<Notice> selectNotice() throws Exception{
		
		Connection conn = getConnection();
		
		List<Notice> list = dao.selectNotice(conn);
		
		close(conn);
		
		return list;
	}

	public List<Notice> noticeOneSelect(int noticeNo) throws Exception{
		
		Connection conn = getConnection();
		
		List<Notice> notice = dao.noticeOneSelect(conn, noticeNo);
		
		close(conn);
		
		return notice;
	}

}
