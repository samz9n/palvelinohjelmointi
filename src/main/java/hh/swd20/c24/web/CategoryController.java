package hh.swd20.c24.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hh.swd20.c24.domain.Category;
import hh.swd20.c24.domain.CategoryRepo;

@Controller
public class CategoryController {
	@Autowired
	CategoryRepo catRepository;

	@GetMapping(value = "/categorylist")
	public String categorylist(Model model) {
		model.addAttribute("categories", catRepository.findAll());
		return "categorylist";
	}

	@GetMapping(value = "/addcategory")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
	}

	@PostMapping(value = "/savecategory")
	public String saveCategory(Category category) {
		catRepository.save(category);
		return "redirect:/categorylist";
	}
}
