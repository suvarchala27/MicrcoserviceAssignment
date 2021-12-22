package com.example.spring.boot.rest.books.model;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="SUBSCRIPTION")
public class Subscription implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Integer getSubscription_id() {
		return subscription_id;
	}

	public void setSubscription_id(Integer subscription_id) {
		this.subscription_id = subscription_id;
	}
	@Id
	@Column(name="SUBSCRIPTION_ID")
	/* @GeneratedValue */
	private Integer subscription_id;
	@Column(name="SUBSCRIBER_NAME")
	private String subscriberName;
	@Column(name="DATE_SUBSCRIBED")
	private ZonedDateTime dateSubscribed;
	@Column(name="DATE_RETURNED")
	private ZonedDateTime dateReturned;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="BOOK_ID")
	private List<Book> book;
	
	
	public String getSubscriberName() {
		return subscriberName;
	}
	
	public List<Book> getBook() {
		return book;
	}
	public void setBook(List<Book> book) {
		this.book = book;
	}
	public void setSubscriberName(String subscriberName) {
		this.subscriberName = subscriberName;
	}
	public ZonedDateTime getDateSubscribed() {
		return dateSubscribed;
	}
	public void setDateSubscribed(ZonedDateTime dateSubscribed) {
		this.dateSubscribed = dateSubscribed;
	}
	public ZonedDateTime getDateReturned() {
		return dateReturned;
	}
	public void setDateReturned(ZonedDateTime dateReturned) {
		this.dateReturned = dateReturned;
	}
	

}
