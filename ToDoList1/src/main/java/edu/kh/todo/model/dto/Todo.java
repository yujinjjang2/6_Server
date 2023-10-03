package edu.kh.todo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든 필드 매개변수 생성자
public class Todo {
	
	private int todoNo;
	private String todoTitle;
	private String todoMemo;
	private String todoDate;
	private String todoDelFl;
	private int memberNo;

}
