package edu.kh.project.member.model.service;

import static edu.kh.project.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.project.member.model.dao.MemberDAO;
import edu.kh.project.member.model.dto.Member;

public class MemberService {
	
	private MemberDAO dao = new MemberDAO();

	// 주석 단축키 : 메소드 커서 -> alt + shift + J
	/** 로그인 서비스
	 * @param inputEmail
	 * @param inputPw
	 * @return
	 */
	public Member login(String inputEmail, String inputPw) throws Exception{
		
		Connection conn = getConnection();
		
		Member loginMember = dao.login(conn, inputEmail, inputPw);
		
		close(conn);
		
		return loginMember;
	}

	/** 회원 검색
	 * @param query
	 * @return
	 */
	public List<Member> searchMember(String query) throws Exception{
		
		Connection conn = getConnection();
		
		List<Member> memberList = dao.searchMember(conn, query);
		
		close(conn);
		
		return memberList;
	}

	

}
