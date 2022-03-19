package com.revature.controllers;


//import java.util.List;
//import org.eclipse.jetty.http.HttpStatus;
import com.revature.exceptions.BookNotFoundException;
import com.revature.models.Book;
import com.revature.services.BookService;
import io.javalin.http.Context;

/*-
 * This class handles HTTP requests related to the Book model
 * 	- the HTTP requests are routed to these methods 
 */
public class BookController {
/*-
 * The BookService field allows the Book controller to leverage its methods to handle the requests
 */
	private static BookService bs = new BookService();
	
	/*- 
	 * The getTasks method handles all GET requests sent to /books including those with Query Params
	 * 		- ie: /books?title=[...]
	 * 			- in this case, title is the name of the query param and [...] is its value
	 * 		- to ensure the proper handling of the request, we have to determine whether a query param is passed or not
	 */
	public static void getAllBooks(Context ctx) {
			ctx.json(bs.getAllBooks()); 
		}

	
	/*-
	 * Handles GET requests for the /books/{id} endpoint
	 * 	- returns a book by its id
	 */
	public static void getBookById(Context ctx) {
		//Retrieves the value of the path param of name id
		String pathParamId = ctx.pathParam("id");
		//converts string to int for manipulation
		int bookId = Integer.parseInt(pathParamId);
		
		// calls on the getBookById from the book dao, throws an exception if the book is not found
		Book b;
		try {
			b = bs.getById(bookId);
			// serializes book object into json and adds it to the HTTP response
			ctx.json(b);
			ctx.status(200);
		} catch (BookNotFoundException e) {
			ctx.status(404);
			ctx.result("Unable to find book of id " + bookId + ".");
			// TODO add proper logging
			e.printStackTrace();
		}
		

	}
	
//	public static void addBook(Context ctx) {
//		//Retrieves new Book from the HTTP body and converts it into a java object of type Book
//		Book newBook= ctx.bodyAsClass(Book.class);
//	
//		/*-
//		 * bs.createBook returns true if the book was successfully created
//		 */
//		if(bs.createBook(newBook)) {
//			ctx.status(HttpStatus.CREATED_201);
//		}else {
//			ctx.status(400);
//			ctx.result("Unable to create book.");
//		}
//	}
//	
//	public static void updateBook(Context ctx) {
//		ctx.status(HttpStatus.NOT_IMPLEMENTED_501);
//		ctx.result("Update book has not been implemented yet.");
//	}
//	
//	public static void deleteBook(Context ctx) {
//		ctx.status(HttpStatus.NOT_IMPLEMENTED_501);
//		ctx.result("delete book has not been implemented yet.");
//	}
}