package hh.swd20.BookStore.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.BookStore.domain.Book;
import hh.swd20.BookStore.domain.BookRepository;
import hh.swd20.BookStore.domain.Category;
import hh.swd20.BookStore.domain.CategoryRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository Crepo;
	
	
	// book listing
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
		public String booklist(Model model) {
		List<Book> books = (List<Book>) repository.findAll();
		model.addAttribute("books", books);
		return "booklist";	
	
	}
	
	// creating empty book form
	@RequestMapping(value = "/newbook", method = RequestMethod.GET)
		public String newBookForm(Model model) {
		model.addAttribute("book", new Book()); //empty book-object
		return "bookform";
	}
	
	//edit book
	@RequestMapping(value = "/editbook/{id}", method = RequestMethod.GET)
		public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));	
		return "editbook";
	}
	
	
	
	// receiving and saving information from book form
	@RequestMapping(value = "/newbook", method = RequestMethod.POST)
		public String saveBook(@ModelAttribute Book book)  {
		//saving one book info into the repository
		repository.save(book);
		return "redirect:/booklist";
	}
	
	// Deleting book
	@RequestMapping(value = "/deletebook/{id}", method = RequestMethod.GET) 
		public String deleteBook(@PathVariable("id") Long bookId) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	
	
}


