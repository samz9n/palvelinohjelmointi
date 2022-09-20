package hh.swd20.c24.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.swd20.c24.domain.Book;
import hh.swd20.c24.domain.BookRepo;

@Controller
public class BookController {
	@Autowired
	BookRepo repository;

	@GetMapping(value = "/index")
	public String getIndex(Model model) {
		return "bookpage";
	}

	@GetMapping(value = "/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}

	@GetMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}

	@PostMapping(value = "/save")
	public String save(Book book) {
		repository.save(book);
		return "redirect:/booklist";
	}

	@GetMapping(value = "/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:/booklist";
	}
}