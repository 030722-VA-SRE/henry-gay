package com.revature;

import com.revature.exceptions.BookNotFoundException;
import com.revature.models.Book;
import com.revature.services.BookService;
import io.javalin.Javalin;

public class Driver {

	public static void main(String[] args) {
		
		BookService bs = new BookService();
		
		Javalin app = Javalin.create();
		app.start(8080);
		
		app.get("books", (ctx)->{
			ctx.json("Welcome to the BookShop API!");
		});
		
		app.get("books/{id}", (ctx)-> {
			int id = Integer.parseInt(ctx.pathParam("id"));
			try {
			Book book = bs.getById(id);
			ctx.json(book);
			ctx.status(200);
			} catch (BookNotFoundException e) {
				ctx.status(404);
				ctx.result("Book of id: " + id + " was not found");
				//log this to file
			}
		});
	}

}
