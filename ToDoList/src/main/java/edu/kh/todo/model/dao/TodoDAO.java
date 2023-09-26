package edu.kh.todo.model.dao;

import static edu.kh.todo.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.todo.model.dto.Todo;

public class TodoDAO {
	
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public TodoDAO() {
		
		try {
			prop = new Properties();
			
			String filePath 
			= TodoDAO.class.getResource("/edu/kh/todo/sql/todo-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public List<Todo> selectTodo(Connection conn, int memNo) throws Exception{
		
		List<Todo> todo = new ArrayList<Todo>();
		
		try {
			
			String sql = prop.getProperty("selectTodo");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int todoNo = rs.getInt("TODO_NO");
				String todoTitle = rs.getString("TODO_TITLE");
				String todoMemo = rs.getString("TODO_MEMO");
				String todoDate = rs.getString("TODO_DATE");
				String todoDelFl = rs.getString("TODO_DEL_FL");
				
				todo.add( new Todo(todoNo, todoTitle, todoMemo,
						todoDate, todoDelFl) );
			}
			
			
		} finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		return todo;
	}

	public int insertTodo(Connection conn, String title, String memo, int memberNo) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("insertTodo");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, memo);
			pstmt.setInt(3, memberNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			
			close(pstmt);
			
		}
		
		return result;
	}

}
