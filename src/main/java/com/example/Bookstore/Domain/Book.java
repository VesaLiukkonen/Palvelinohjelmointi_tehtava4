package com.example.Bookstore.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	private String title;
    private String author;
    private String isbn;
    private double bookYear;
    private double price;

    public Book() {}

	public Book(String title, String author, String isbn, double year, double price) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.bookYear = year;
		this.price = price;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getBookYear() {
		return bookYear;
	}

	public void setBookYear(double bookYear) {
		this.bookYear = bookYear;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + "title=" + title + ", author=" + author + ", year=" + bookYear + ", isbn=" + isbn + ", price=" + price
				+ "]";
	}
}