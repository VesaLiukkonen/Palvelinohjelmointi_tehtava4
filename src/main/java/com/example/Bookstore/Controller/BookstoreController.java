package com.example.Bookstore.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Bookstore.Domain.Book;
import com.example.Bookstore.Domain.Category;
import com.example.Bookstore.Domain.BookRepository;
import com.example.Bookstore.Domain.CategoryRepository;


	@Controller
		public class BookstoreController {
		
	@Autowired
	private BookRepository brepository;
	
	@Autowired
	private CategoryRepository crepository; 

	@RequestMapping(value= {"/", "booklist"})
    public String booklist(Model model) {	
        model.addAttribute("books", brepository.findAll());
        return "booklist";
    }
	
	@RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {	
        return (List<Book>) brepository.findAll();
    }
	
	@RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {	
    	return brepository.findById(bookId);
    }
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	brepository.deleteById(bookId);
        return "redirect:../booklist";
    }
	
	@RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categories", crepository.findAll());
        return "addbook";
    }
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long bookId, Model model) {
    	model.addAttribute("book", brepository.findById(bookId));
    	model.addAttribute("categories", crepository.findAll());
    	return "editbook";
    }
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        brepository.save(book);
        return "redirect:booklist";
    }    
	
}
