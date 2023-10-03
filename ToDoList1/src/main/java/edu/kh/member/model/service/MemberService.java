package edu.kh.member.model.service;

import java.sql.Connection;
import java.util.List;

import edu.kh.member.model.dao.MemberDAO;
import edu.kh.member.model.dto.Member;

import static edu.kh.todo.common.JDBCTemplate.*;

public class MemberService {
	
	MemberDAO dao = new MemberDAO();

	public List<Member> selectMember(String id, String pw) throws Exception{
		
		Connection conn = getConnection();
		
		List<Member> member = dao.selectMember(conn, id, pw);
		
		close(conn);
		
		return member;
	}

	public int insertMember(String id, String pw, String nm) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.insertMember(conn, id, pw, nm);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

}
