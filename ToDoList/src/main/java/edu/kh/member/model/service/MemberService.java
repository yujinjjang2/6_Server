package edu.kh.member.model.service;

import static edu.kh.todo.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.List;

import edu.kh.member.model.dao.MemberDAO;
import edu.kh.member.model.dto.Member;

public class MemberService {

	MemberDAO dao = new MemberDAO();

	public List<Member> selectLogin(String id, String pw) throws Exception{
		
		Connection conn = getConnection();
		
		List<Member> member = dao.selectLogin(conn, id, pw);
		
		close(conn);
		
		return member;
	}

	public int insertMember(String id, String pw, String nm) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.insertMember(conn, id, pw, nm);
		
		if(result > 0) commit(conn);
		else		   rollback(conn);
		
		return result;
	}

}
