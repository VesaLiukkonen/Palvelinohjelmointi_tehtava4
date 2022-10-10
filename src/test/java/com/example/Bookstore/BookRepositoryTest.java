package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Test;

import com.example.Bookstore.Domain.Book;
import com.example.Bookstore.Domain.BookRepository;
import com.example.Bookstore.Domain.Category;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    public void findByTitleShouldReturnBook() {
        List<Book> books = repository.findByTitle("Metoro 2033");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Dmitry Glukhovsky");
    }
    
    @Test
    public void createNewBook() {
    	Book book = new Book("Nineteen eighty-four", "George Orwell", "978-0-141-03614-4", 1949, 10, new Category("Dystopian"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    
    @Test
    public void deleteNewBook() {
		List<Book> books = repository.findByTitle("Metro 2033");
		Book book = books.get(0);
		repository.delete(book);
		List<Book> newBooks = repository.findByTitle("Metro 2033");
		assertThat(newBooks).hasSize(0);
     }

}