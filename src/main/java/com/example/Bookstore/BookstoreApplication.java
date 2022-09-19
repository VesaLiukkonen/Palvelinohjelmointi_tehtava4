package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.Domain.Book;
import com.example.Bookstore.Domain.BookRepository;
import com.example.Bookstore.Domain.Category;
import com.example.Bookstore.Domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner bookstoreDemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save a couple of books");
			crepository.save(new Category("Sci-fi"));
			crepository.save(new Category("Romance"));
			crepository.save(new Category("History"));
			
			brepository.save(new Book("Roadside Picninc", "Arkady & Boris Strugatsky", "978-0-575-09313-3", 1977, 10, crepository.findByName("Sci-fi").get(0)));
			brepository.save(new Book("Metro 2033", "Dmitry Glukhovsky", "978-0-575-08625-8", 2005, 10, crepository.findByName("Sci-fi").get(0)));	
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
