package com.example.spring.boot.rest.books.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.spring.boot.rest.books.model.Book;
import com.example.spring.boot.rest.books.model.Subscription;

	@Repository
	public interface SubscriberRepository extends JpaRepository<Subscription, Integer> {
		public final static String book_availability ="Select b from book b where b.AVAILABLE_COPIES!=0";

		@Query(book_availability)
		public List<Book> findByBookId(@Param("id") int id);

		public List<Book> findByBookId(Integer bookId);
		
	
	}


