package edu.kh.todo.model.service;

import java.sql.Connection;
import java.util.List;

import edu.kh.todo.model.dao.TodoDAO;
import edu.kh.todo.model.dto.Todo;

import static edu.kh.todo.common.JDBCTemplate.*;

public class TodoService {
	
	TodoDAO dao = new TodoDAO();

	public List<Todo> selectTodo(int memNo) throws Exception{
		
		Connection conn = getConnection();
		
		List<Todo> todo = dao.selectTodo(conn, memNo);
		
		close(conn);
		
		return todo;
	}

	public int insertTodo(String title, String memo, int memNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.insertTodo(conn, title, memo, memNo);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	public List<Todo> selectOne(String todoNo) throws Exception{
		
		Connection conn = getConnection();
		
		List<Todo> todo = dao.selectOne(conn, todoNo);
		
		close(conn);
		
		return todo;
	}

	public int updateTodo(String todoNo, String title, String memo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.updateTodo(conn, todoNo, title, memo);
		
		if(result > 0) commit(conn);
		else 			rollback(conn);
		
		close(conn);
		
		return result;
	}

	public int deleteTodo(String todoNo) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.deleteTodo(conn, todoNo);
		
		if(result > 0) commit(conn);
		else 			rollback(conn);
		
		close(conn);
		
		return result;
	}

}
