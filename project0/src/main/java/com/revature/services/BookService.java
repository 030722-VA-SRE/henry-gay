package com.revature.services;

import java.util.List;
import com.revature.daos.BookDao;
import com.revature.daos.BookPostgres;
import com.revature.exceptions.BookNotFoundException;
import com.revature.models.Book;

public class BookService {

	private BookDao bDao;
	
	public BookService() {
		bDao = new BookPostgres();
	}
	
	public List<Book> getAllBooks(){
		return bDao.getAllBooks();
	}
	
	public Book getById(int id) throws BookNotFoundException {
		Book book = bDao.getBookById(id);
		
		if(book == null) {
			throw new BookNotFoundException();
		}
		
		return book;
	}
}
