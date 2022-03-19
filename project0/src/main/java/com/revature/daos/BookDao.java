package com.revature.daos;

import java.util.List;
import com.revature.models.Book;

public interface BookDao {

	public List<Book> getAllBooks();
	public Book getBookById(int id);
//	public int createBook(Book book);
//	public boolean updateBook(Book book);
//	public boolean deleteBookById(int id);
}
