package hh.swd20.c24;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.c24.domain.Book;
import hh.swd20.c24.domain.BookRepo;
import hh.swd20.c24.domain.Category;
import hh.swd20.c24.domain.CategoryRepo;

@SpringBootApplication
public class Application {
	private static final org.jboss.logging.Logger log = LoggerFactory.logger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner bookRunner(BookRepo repository, CategoryRepo catRepository) {
		return (args) -> {
			log.info("save some books");
			repository.save(new Book("Demo", "Harry", 1889, "1111222", 12.99));
			repository.save(new Book("MyBook", "Larry", 1994, "111122233", 13.99));

			log.info("Fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

			log.info("save some categories");
			catRepository.save(new Category("Scifi"));
			catRepository.save(new Category("Action"));

			log.info("Fetch all the categories");
			for (Category cat : catRepository.findAll()) {
				log.info(cat.toString());
			}
		};
	}
}
