package hh.swd20.BookStore.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.BookStore.domain.Book;
import hh.swd20.BookStore.domain.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	public void showBooks() {
		List<hh.swd20.BookStore.domain.Book> books = repository.findById('1');
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
	return (args) -> {
	repository.save(new Book
			("Bridget Jones, Elämä jatkuu", "Helen Fielding", 1999, "978-951-1-27713-2", 6.50 ));
	repository.save(new Book
			("Idiootit ympärilläni", "Thomas Erikson", 2017, "978-952-300-321-7", 17.95));
	repository.save(new Book
			("The Crown", "Robert Lacey", 2017, "978-951-1-32191-0", 26.95));
	};
	}
	
	
//	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
//		public String booklist(@ModelAttribute Model model) {
//		List<Book> books = (List<Book>) repository.findAll();
//		model.addAttribute("books", books);
		
//			return "booklist";	
	
//	}
	
}


