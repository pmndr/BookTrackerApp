package com.bookTracker.BookTrackerApp;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repo;
	
	public void saveBook(Book b) {
		repo.save(b);
	}
	
	public List<Book> getAllBooks() {
		return repo.findAll();
	}
	
	public void deleteById(int id) {
		repo.deleteById(id);
	}
	
	

}
