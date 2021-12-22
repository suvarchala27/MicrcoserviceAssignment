package com.example.spring.boot.rest.books.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
public class Book implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BOOK_ID")
	private Integer bookId;
	
	@Column(name="BOOK_NAME")
	private String bookName;
	@Column(name="AUTHOR")
	private String author;
	@Column(name="AVAILABLE_COPIES")
	private Long availableCopies;
	@Column(name="TOTAL_COPIES")
	private Long totatCopies;

 	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Long getAvailableCopies() {
		return availableCopies;
	}
	public void setAvailableCopies(Long availableCopies) {
		this.availableCopies = availableCopies;
	}
	public Long getTotatCopies() {
		return totatCopies;
	}
	public void setTotatCopies(Long totatCopies) {
		this.totatCopies = totatCopies;
	}
	
}
