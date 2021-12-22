package com.example.spring.boot.rest.books.service;

import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.boot.rest.books.model.Book;
import com.example.spring.boot.rest.books.model.Subscription;
import com.example.spring.boot.rest.books.repository.SubscriberRepository;

@Service
public class SubscriptionService {

	@Autowired
	SubscriberRepository subscriberRepository;
	private Integer bookId;
	private Long availableCopies;

	public Integer addSubscriber(Subscription s) {
		bookId = s.getBook().get(0).getBookId();

		List<Book> b = subscriberRepository.findByBookId(bookId);
		Iterator<Book> i = b.iterator();
		if (i.hasNext())
			availableCopies = i.next().getAvailableCopies();
		subscriberRepository.save(s);

		return s.getSubscription_id();

	}

	public List<Subscription> fetchAllSubscriptions() {

		return subscriberRepository.findAll();

	}

}