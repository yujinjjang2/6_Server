package edu.kh.todo.model.service;

import static edu.kh.todo.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.todo.model.dao.TodoDAO;
import edu.kh.todo.model.dto.Todo;

public class TodoService {

	TodoDAO dao = new TodoDAO();
	
	public List<Todo> selectTodo(int memNo) throws Exception{
		
		Connection conn = getConnection();
		
		List<Todo> todo = dao.selectTodo(conn, memNo);
		
		close(conn);
		
		return todo;
	}

	public int insertTodo(String title, String memo, int memberNo) throws Exception{
		 
		Connection conn = getConnection();
		
		int result = dao.insertTodo(conn, title, memo, memberNo);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}
}
