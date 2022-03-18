package com.revature.models;

import java.util.Objects;

public class Book {
	
	private int id;
	private String isbn;
	private String title;
	private String author;
	private int yearPublished;
	
	public Book() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, id, isbn, title, yearPublished);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && id == other.id && Objects.equals(isbn, other.isbn)
				&& Objects.equals(title, other.title) && yearPublished == other.yearPublished;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", author=" + author + ", yearPublished="
				+ yearPublished + "]";
	}

}