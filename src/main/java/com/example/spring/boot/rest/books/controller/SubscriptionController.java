package com.example.spring.boot.rest.books.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.example.spring.boot.rest.books.model.ResponseMessage;
import com.example.spring.boot.rest.books.model.Subscription;
import com.example.spring.boot.rest.books.service.SubscriptionService;


	@RestController
	@RequestMapping("/subscriptions")
	public class SubscriptionController {
		
		@Autowired
		SubscriptionService subscriptionService;
		
		@PostMapping("/subscription")
		public ResponseEntity<ResponseMessage> createEmployee(@RequestBody @Valid Subscription s) throws Exception {
			subscriptionService.addSubscriber(s);
			
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(s.getSubscription_id())
					.toUri();
			return ResponseEntity.created(location).build();
			
		
		
	}

		@GetMapping
		public List<Subscription> getSubscriptions() {
			return subscriptionService.fetchAllSubscriptions();
	}

	}
