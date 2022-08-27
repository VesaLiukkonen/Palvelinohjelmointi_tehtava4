package com.example.Bookstore.Control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookstoreControl {

	@GetMapping("/index") 
	public String sayHelloToSomeone(@RequestParam(name="location") String location,
			@RequestParam(name="name") String name){
		return "index";
	}
}
