package com.example.spring.boot.rest.books.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.boot.rest.books.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
}
