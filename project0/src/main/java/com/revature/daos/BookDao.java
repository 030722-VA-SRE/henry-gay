package com.revature.daos;

import java.util.List;
import com.revature.models.Book;

public interface BookDao {

	public List<Book> getAllBooks();
	public List<Book> getBooksByTitle(String title);
	public List<Book> getBooksByAuthor(String author);
	public List<Book> getBooksByTitleAndAuthor(String title, String author);
	public Book getBookById(int id);
	public int addBook(Book book);
	public boolean updateBook(Book book);

}
