package com.bookTracker.BookTrackerApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
//	@GetMapping("/available")
//	public String available() {
//		return "available";
//	}
	
	@GetMapping("/available")
	public ModelAndView available() {
		List<Book> list = service.getAllBooks();
		
		ModelAndView m = new ModelAndView();
		m.setViewName("available");
		m.addObject("book", list);
		return m;
		
		// return new ModelAndView("available", "book", list);
		
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		service.saveBook(b);
		return "redirect:/available";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/available";
	}

}
