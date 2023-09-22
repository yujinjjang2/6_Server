package edu.kh.project.member.model.dao;

import static edu.kh.project.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.project.member.model.dto.Member;

public class MemberDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public MemberDAO() {
		
		try {
			prop = new Properties();
			
			String filePath 
				= MemberDAO.class.getResource("/edu/kh/project/sql/member-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

	/** 로그인 DAO
	 * @param conn
	 * @param inputEmail
	 * @param inputPw
	 * @return
	 */
	public Member login(Connection conn, String inputEmail, String inputPw) throws Exception{
		
		Member loginMember = null;
		
		try {
			
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, inputEmail);
			pstmt.setString(2, inputPw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				loginMember = new Member();
				
				loginMember.setMemberNo( rs.getInt(1) );
				loginMember.setMemberEmail( rs.getString(2) );
				loginMember.setMemberNickname( rs.getString(3) );
				loginMember.setMemberTel( rs.getString(4) );
				loginMember.setMemberAddress( rs.getString(5) );
				loginMember.setProfileImage( rs.getString(6) );
				loginMember.setAuthority( rs.getInt(7) );
				loginMember.setEnrollDate( rs.getString(8) );
			}
			
			
			
		} finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		return loginMember;
	}
	
	

	/** 회원 검색
	 * @param conn
	 * @param query
	 * @return
	 */
	public List<Member> searchMember(Connection conn, String query) throws Exception{
		
		List<Member> memberList = new ArrayList<Member>();
		
		try {
			
			String sql = prop.getProperty("searchMember");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, query);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Member member = new Member();
				
				member.setMemberNo( rs.getInt("MEMBER_NO") );
				member.setMemberEmail( rs.getString("MEMBER_EMAIL") );
				member.setMemberNickname( rs.getString("MEMBER_NICKNAME") );
				member.setMemberTel( rs.getString("MEMBER_TEL") );
				
				memberList.add(member);
				
			}
			
		} finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		
		return memberList;
	}

}
