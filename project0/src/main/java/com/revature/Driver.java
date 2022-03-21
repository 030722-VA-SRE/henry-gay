package com.revature;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
//import static io.javalin.apibuilder.ApiBuilder.put;
import com.revature.controllers.BookController;
import io.javalin.Javalin;

public class Driver {

	public static void main(String[] args) {
		
		Javalin app = Javalin.create((config) -> {
			config.enableCorsForAllOrigins();
			
			config.defaultContentType = "application/json";
		});
		
		app.start(8080);
		
		app.routes(() -> {
			path("books", () -> {
				
				get(BookController::getAllBooks);
				
				post(BookController::addBooks);
				
				path("{id}", () -> {
					
					get(BookController::getBookById);
					
//					put(BookController::updateBook);
					
				});
				
			});
		});
	}
}