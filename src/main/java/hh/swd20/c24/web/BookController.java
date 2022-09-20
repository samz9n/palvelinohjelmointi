package hh.swd20.c24.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
