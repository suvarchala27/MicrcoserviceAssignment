package com.example.spring.boot.rest.books.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.example.spring.boot.rest.books.model.Book;
import com.example.spring.boot.rest.books.model.ResponseMessage;
import com.example.spring.boot.rest.books.service.BooksService;

@RestController
@RequestMapping("/books")
public class BooksController {
	
	@Autowired
	BooksService bookService;
	

	@GetMapping
	public List<Book> getBooks() {
		return bookService.fetchAllBooks();
}
	
	
	@PostMapping("/book")
	public ResponseEntity<ResponseMessage> createEmployee(@RequestBody @Valid Book book) throws Exception {
		bookService.addBook(book);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(book.getBookId())
				.toUri();
		return ResponseEntity.created(location).build();
		
	
	
}@GetMapping("book/{id}")
public Optional<Book> getBookById(@PathVariable Integer id){
	
	return bookService.fetchBookById(id);
}
}
