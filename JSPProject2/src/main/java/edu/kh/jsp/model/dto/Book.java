package edu.kh.jsp.model.dto;

public class Book {
	private String title;
	private String writer;
	private int price;
	
	// 생성자 단축키 : ctrl + space
	public Book() {}

	// 매개변수 생성자 단축키 : alt + shift + s -> o
	public Book(String title, String writer, int price) {
		super();
		this.title = title;
		this.writer = writer;
		this.price = price;
	}

	// Getter/Setter 단축키 : alt + shift + s -> r
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
