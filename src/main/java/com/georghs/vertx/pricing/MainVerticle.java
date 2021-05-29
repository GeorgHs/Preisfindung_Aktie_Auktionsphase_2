package com.georghs.vertx.pricing;


import com.georghs.vertx.pricing.components.Currency;
import com.georghs.vertx.pricing.components.Stock;

import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.StaticHandler;

public class MainVerticle extends AbstractVerticle {

	private InMemoryBookStore store = new InMemoryBookStore();

	@Override
	public void start(Promise<Void> startPromise) throws Exception {

		Stock st = new Stock("sdfsd", "sdfsdf", Currency.AUD);

	  Router books = Router.router(vertx);
	  books.route().handler(BodyHandler.create());
	  books.route("/*").handler(StaticHandler.create());

	  // Get /books
	  getAll(books);

	  // POST /books
	  createBook(books);

	  //PUT /books/:isbn
	  updateBook(books);

	  registerErrorHandler(books);

	  //GET /books/:isbn -> fetch one book
	  getBookByISBN(books);

	  //DELETE /books/:isbn -> delete one book from in memory store
	  deleteBook(books);

    vertx.createHttpServer().requestHandler(books).listen(8888, http -> {
    	if (http.succeeded()) {
    		startPromise.complete();
    		System.out.println("HTTP server started on port 8888");
    	} else {
    		startPromise.fail(http.cause());
    	}
    });
	}

	private void deleteBook(Router books) {
		books.delete("/books/:isbn").handler(req -> {
			  final String isbn = req.pathParam("isbn");
			  final Stock deletedBook = store.delete(isbn);
			  if (null == deletedBook) {
				  //Book not found
				  req.response().putHeader(HttpHeaders.CONTENT_TYPE, HttpHeaderValues.APPLICATION_JSON)
				  .setStatusCode(HttpResponseStatus.NOT_FOUND.code())
				  .end(new JsonObject().put("error", "Book not found!").encode());
			  } else {
				  // Deleted a book
				  req.response().putHeader(HttpHeaders.CONTENT_TYPE, HttpHeaderValues.APPLICATION_JSON)
				  .end(JsonObject.mapFrom(deletedBook).encode());
			  }
		  });
	}

	private void getBookByISBN(Router books) {
		books.get("/books/:isbn").handler(req -> {
			  final String isbn = req.pathParam("isbn");
			  req.response()
			  	.putHeader(HttpHeaders.CONTENT_TYPE, HttpHeaderValues.APPLICATION_JSON)
			  	.end(JsonObject.mapFrom(store.get(isbn)).encode());
		  });
	}

	private void registerErrorHandler(final Router books) {
		books.errorHandler(500, event -> {
			System.err.println("Failed" + event.failure());
			if (event.failure() instanceof IllegalArgumentException) {
				event.response().putHeader(HttpHeaders.CONTENT_TYPE, HttpHeaderValues.APPLICATION_JSON)
				.setStatusCode(HttpResponseStatus.BAD_REQUEST.code())
				.end(new JsonObject().put("error ", event.failure().getMessage()).encode());
				return;
			}

			  event.response()
			  	.putHeader(HttpHeaders.CONTENT_TYPE, HttpHeaderValues.APPLICATION_JSON)
			  	.setStatusCode(HttpResponseStatus.INTERNAL_SERVER_ERROR.code())
			  	.end(new JsonObject().put("error", event.failure().getMessage()).encode());
		  });
	}

	private void updateBook(Router books) {
		books.put("/books/:isbn").handler(req -> {
			  final String isbn = req.pathParam("isbn");
			  final JsonObject requestBody = req.getBodyAsJson();
			  final Stock updatedBook = store.update(isbn, requestBody.mapTo(Stock.class));
			  // Return response
			  req.response()
			  	.putHeader(HttpHeaders.CONTENT_TYPE, HttpHeaderValues.APPLICATION_JSON)
			  	.end(JsonObject.mapFrom(updatedBook).encode());
		  });
	}

	private void createBook(Router books) {
		books.post("/books").handler(req -> {
			  final JsonObject requestBody = req.getBodyAsJson();
			  System.out.println("Request Body: " + requestBody);
			  //Store
			  store.add(requestBody.mapTo(Stock.class));
			  // Return response
			  req.response()
			  	.putHeader(HttpHeaders.CONTENT_TYPE, HttpHeaderValues.APPLICATION_JSON)
			  	.setStatusCode(HttpResponseStatus.CREATED.code())
			  	.end(requestBody.encode());

		  });
	}

	private void getAll(Router books) {
		books.get("/books").handler(req -> {
			  // Return response
			  req.response()
			  	.putHeader(HttpHeaders.CONTENT_TYPE, HttpHeaderValues.APPLICATION_JSON)
			  	.end(store.getAll().encode());
		  });
	}

  public static void main(String[] args) {
	Vertx vertx = Vertx.vertx();
	vertx.deployVerticle(new MainVerticle());
}
}
