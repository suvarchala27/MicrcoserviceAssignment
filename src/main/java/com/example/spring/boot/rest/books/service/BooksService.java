package com.example.spring.boot.rest.books.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.spring.boot.rest.books.model.Book;
import com.example.spring.boot.rest.books.repository.BookRepository;

@Service
public class BooksService {
	
	@Autowired
	BookRepository bookRepository;
	

	public Integer addBook(Book b) {
		bookRepository.save(b);
		
		return b.getBookId();

}
public Optional<Book> fetchBookById(Integer id) {
		
		return bookRepository.findById(id);
		
		
	}
public List<Book> fetchAllBooks() {
	
	return bookRepository.findAll();
	
	}


}