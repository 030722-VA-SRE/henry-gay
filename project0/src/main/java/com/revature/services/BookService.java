package com.revature.services;

import java.util.List;
import com.revature.daos.BookDao;
import com.revature.daos.BookPostgres;
import com.revature.exceptions.BookNotFoundException;
import com.revature.models.Book;

public class BookService {

	private BookDao bDao;

	public BookService(BookDao mockDao) {
		super();
	}
	
	public BookService() {
		bDao = new BookPostgres();
	}
	
	public List<Book> getAllBooks(){
		return bDao.getAllBooks();
	}
	
	public List<Book> getBooksByTitle(String title){
		return bDao.getBooksByTitle(title);
	}

	public List<Book> getBooksByAuthor(String author){
		return bDao.getBooksByAuthor(author);
	}
	
	public List<Book> getBooksByTitleAndAuthor(String title, String author){
		return bDao.getBooksByTitleAndAuthor(title, author);
	}
	
	public Book getById(int id) throws BookNotFoundException {
		Book book = bDao.getBookById(id);
		
		if(book == null) {
			throw new BookNotFoundException();
		}
		
		return book;
	}
	
	public boolean addBook(Book book) {
		int generatedId = bDao.addBook(book);
		if(generatedId != -1) {
			return true;
		}
		return false;
	}
	
	public boolean updateBook(Book book) {
		return bDao.updateBook(book);
	}
}
