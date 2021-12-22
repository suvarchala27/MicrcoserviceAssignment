package com.example.spring.boot.rest.books;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.spring.boot.rest.books.model.Book;
import com.example.spring.boot.rest.books.model.Subscription;
import com.example.spring.boot.rest.books.repository.SubscriberRepository;

@DataJpaTest
class SubscriberRepositoryTest {
   @Autowired
   private SubscriberRepository subscriberRepository;
   List<Book> bookList = new ArrayList<Book>();
   
   @BeforeEach
   void setUp() {
	   Subscription s1=new Subscription();
	   s1.setSubscription_id(1);
	   s1.setSubscriberName("name1");
	   s1.setDateSubscribed(ZonedDateTime.now());
	   s1.getDateReturned();
	   
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
	   bookList.add(book1);
	  s1.setBook(bookList); 
	 
	  subscriberRepository.save(s1);
    }
  
   @Test
   void fetchAllSubscriptions() {
      List<Subscription> result = subscriberRepository.findAll();
      assertThat(result, is(notNullValue()));
   }
   
	
	  @AfterEach void tearDown() { 
		  
		 subscriberRepository.deleteAll();
	  }
	 
	 }
