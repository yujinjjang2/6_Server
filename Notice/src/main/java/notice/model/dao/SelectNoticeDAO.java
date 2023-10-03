package notice.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import notice.model.dto.Notice;

import static notice.common.JDBCTemplate.*;

public class SelectNoticeDAO {
	
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public SelectNoticeDAO() {
		
		try {
			prop = new Properties();
			
			String filePath 
			= SelectNoticeDAO.class.getResource("/notice/sql/Notice-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public List<Notice> selectNotice(Connection conn) throws Exception{
		
		List<Notice> list = new ArrayList<Notice>();
		
		try {
			
			String sql = prop.getProperty("selectNotice");
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int noticeNo = rs.getInt("NOTICE_NO");
				int managerNo = rs.getInt("MANAGER_NO");
				String noticeTitle = rs.getString("NOTICE_TITLE");
				String noticeDetail = rs.getString("NOTICE_DETAIL");
				String noticeUploadDate = rs.getString("NOTICE_UPLOAD_DATE");
				String preTitle = "";
				String nextTitle = "";
				
				list.add( new Notice(noticeNo, managerNo, noticeTitle, noticeDetail, noticeUploadDate, preTitle, nextTitle) );
				
			}
			
		} finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		return list;
	}

	public List<Notice> noticeOneSelect(Connection conn, int noticeNo) throws Exception{
		
		List<Notice> notice = new ArrayList<Notice>();
		
		try {
			
			String sql = prop.getProperty("noticeOneSelect");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, noticeNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int noticeNo1 = rs.getInt("NOTICE_NO");
				int managerNo = rs.getInt("MANAGER_NO");
				String noticeTitle = rs.getString("NOTICE_TITLE");
				String noticeDetail = rs.getString("NOTICE_DETAIL");
				String noticeUploadDate = rs.getString("NOTICE_UPLOAD_DATE");
				String preTitle = rs.getString("PRE_TITLE");
				String nextTitle = rs.getString("NEXT_TITLE");
				
				notice.add( new Notice(noticeNo1, managerNo, noticeTitle, noticeDetail, noticeUploadDate, preTitle, nextTitle) );
				
			}
			
		} finally {
			
			close(rs);
			close(pstmt);
			
		}
		return notice;
	}

}
