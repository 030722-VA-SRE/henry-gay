package com.revature.controllers;

import org.eclipse.jetty.http.HttpStatus;
import java.util.List;
import com.revature.exceptions.BookNotFoundException;
import com.revature.models.Book;
import com.revature.services.BookService;
import io.javalin.http.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*-
 * This class handles HTTP requests related to the Book model
 * 	- the HTTP requests are routed to these methods 
 */
public class BookController {
	/*-
	 * The LogManager will be included to store errors and info about incorrect input
	 */
	private static Logger log = LogManager.getRootLogger();
	/*-
	 * The BookService field allows the Book controller to leverage its methods to handle the requests
	 */
	private static BookService bs = new BookService();

	/*- 
	 * The getBooks method handles all GET requests sent to /books including those with Query Params
	 * 		- ie: /books?title=[...]
	 * 			- in this case, title is the name of the query param and [...] is its value
	 * 		- to ensure the proper handling of the request, we have to determine whether a query param is passed or not
	 */
	public static void getAllBooks(Context ctx) {

		String title = ctx.queryParam("title");
		String author = ctx.queryParam("author");

		if (title == null && author == null) {
			ctx.json(bs.getAllBooks());
		} else if (title != null && author == null) {
			List<Book> books = bs.getBooksByTitle(title);
			ctx.json(books);
		} else if (title == null && author != null) {
			List<Book> books = bs.getBooksByAuthor(author);
			ctx.json(books);
		} else {
			List<Book> books = bs.getBooksByTitleAndAuthor(title, author);
			ctx.json(books);
		}
	}

	/*-
	 * Handles GET requests for the /books/{id} endpoint
	 * 	- returns a book by its id
	 */
	public static void getBookById(Context ctx) {
		// Retrieves the value of the path param of name id
		String pathParamId = ctx.pathParam("id");
		// converts string to int for manipulation
		int bookId = Integer.parseInt(pathParamId);

		// calls on the getBookById from the book dao, throws an exception if the book
		// is not found
		Book b;
		try {
			b = bs.getById(bookId);
			// serializes book object into json and adds it to the HTTP response
			ctx.json(b);
			ctx.status(200);
		} catch (BookNotFoundException e) {
			ctx.status(404);
			ctx.result("Unable to find book of id " + bookId + ".");
			log.error(e.fillInStackTrace());
			e.printStackTrace();
		}

	}

	public static void addBooks(Context ctx) {
		/*-
		 *  Retrieves new Book from the HTTP body and converts
		 *  it into a java object of type Book
		 */
		 
		Book newBook = ctx.bodyAsClass(Book.class);

		/*-
		 * bs.addBook returns true if the book was successfully created
		 */
		if (bs.addBook(newBook)) {
			ctx.status(HttpStatus.CREATED_201);
		} else {
			ctx.status(HttpStatus.NOT_FOUND_404);
			ctx.result("Unable to create book.");
		}
	}

	public static void updateBook(Context ctx) {
		/*-
		 *  Retrieves new Book from the HTTP body and converts
		 *  it into a java object of type Book
		 */
		Book updatedBook = ctx.bodyAsClass(Book.class);
		
		/*-
		 * bs.addBook returns true if the book was successfully updated
		 */
		if(bs.updateBook(updatedBook)) {
		ctx.status(HttpStatus.OK_200);
		} else {
			ctx.status(HttpStatus.NOT_FOUND_404);
		ctx.result("Unable to update book");
		}
	}
}