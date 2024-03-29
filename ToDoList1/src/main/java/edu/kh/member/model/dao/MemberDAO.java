package edu.kh.member.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.member.model.dto.Member;

import static edu.kh.todo.common.JDBCTemplate.*;

public class MemberDAO {
	
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public MemberDAO() {
		
		try {
			
			prop = new Properties();
			
			String filePath 
			= MemberDAO.class.getResource("/edu/kh/todo/sql/member-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public List<Member> selectMember(Connection conn, String id, String pw) throws Exception{
		
		List<Member> member = new ArrayList<Member>();
		
		try {
			
			String sql = prop.getProperty("selectMember");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int memberNo = rs.getInt("MEMBER_NO");
				String memberId = rs.getString("MEMBER_ID");
				String memberPw = rs.getString("MEMBER_PW");
				String memberNickname = rs.getString("MEMBER_NICKNAME");
				String enrollDate = rs.getString("ENROLL_DATE");
				String memberDelFl = rs.getString("MEMBER_DEL_FL");
			
				member.add( new Member(memberNo, memberId, memberPw, memberNickname, enrollDate, memberDelFl) ); 
			}
			
		} finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		return member;
	}

	public int insertMember(Connection conn, String id, String pw, String nm) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("insertMember");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, nm);
			
			result = pstmt.executeUpdate();
			
		} finally {
			
			close(pstmt);
			
		}
		
		return result;
	}

}
