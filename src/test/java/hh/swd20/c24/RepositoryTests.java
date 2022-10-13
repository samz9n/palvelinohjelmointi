package hh.swd20.c24;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.c24.domain.Book;
import hh.swd20.c24.domain.BookRepo;
import hh.swd20.c24.domain.Category;
import hh.swd20.c24.domain.CategoryRepo;
import hh.swd20.c24.domain.User;
import hh.swd20.c24.domain.UserRepository;

@ExtendWith(SpringExtension.class) // JUnit5 eli Jupiter
@DataJpaTest
public class RepositoryTests {
	@Autowired
	private BookRepo bookRepo;
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private UserRepository userRepo;

	@Test
	public void createBookTest() {
		Book book = new Book("testbook", "testAuthor", 1994, "1235", 12.99, null);
		bookRepo.save(book);
		assertThat(book.getId()).isNotNull();
	}

	@Test
	public void deleteBookTest() {
		Book book2 = new Book("testdelbook", "testAuthor", 1994, "1235", 12.99, null);
		bookRepo.save(book2);
		bookRepo.deleteById(book2.getId());
		assertThat(bookRepo.findByTitle("testdelbook") == null);
	}

	@Test
	public void findBookTest() {
		Book book3 = new Book("testfindbook", "testAuthor", 1994, "1235", 12.99, null);
		bookRepo.save(book3);
		assertThat(bookRepo.findByTitle("testfindbook") != null);
	}

	@Test
	public void createAndSearchCategoryTest() {
		Category cat = new Category("Test");
		categoryRepo.save(cat);
		List<Category> categories = categoryRepo.findByName("Test");
		assertThat(categories).hasSize(1);
	}

	@Test
	public void deleteCategoryTest() {
		Category cat = new Category("Test");
		categoryRepo.save(cat);
		categoryRepo.delete(cat);
		assertThat(categoryRepo.findByName("Test") == null);
	}

	@Test
	public void createAndSearchUserTest() {
		User user = new User("Test", "Test", "Test", "Test");
		userRepo.save(user);
		assertThat(userRepo.findByUsername("Test") != null);
	}

	@Test
	public void deleteUserTest() {
		User user = new User("Test", "Test", "Test", "Test");
		userRepo.save(user);
		userRepo.delete(user);
		assertThat(userRepo.findByUsername("Test") == null);
	}

}
