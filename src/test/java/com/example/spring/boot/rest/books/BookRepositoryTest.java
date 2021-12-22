package com.example.spring.boot.rest.books;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.spring.boot.rest.books.model.Book;
import com.example.spring.boot.rest.books.repository.BookRepository;
import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
class BookRepositoryTest {
   @Autowired
   private BookRepository bookRepository;
   
   @BeforeEach
   void setUp() {
	   Book book1=new Book();
	   book1.setBookId(1);
	   book1.setAuthor("Maths");
	   book1.setBookName("Srinivasan");
	   book1.setAvailableCopies(4L);
	   book1.setTotatCopies(5l);
	   
	   Book book2=new Book();
	   book2.setBookId(1);
	   book2.setAuthor("Wren");
	   book2.setBookName("English");
	   book2.setAvailableCopies(3L);
	   book2.setTotatCopies(5l);
	   
	   bookRepository.save(book1);
       bookRepository.save(book2);
	   
   }
  
   
   @Test
   void findAllBooks() {
      List<Book> result = bookRepository.findAll();
      assertThat(result, is(notNullValue()));
   }
   
  
   @AfterEach
   void tearDown() {
      bookRepository.deleteAll();
   }
   
}
