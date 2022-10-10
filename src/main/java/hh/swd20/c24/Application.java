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
import hh.swd20.c24.domain.User;
import hh.swd20.c24.domain.UserRepository;

@SpringBootApplication
public class Application {
	private static final org.jboss.logging.Logger log = LoggerFactory.logger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner bookRunner(BookRepo repository, CategoryRepo catRepository, UserRepository uRepository) {
		return (args) -> {
			log.info("save some books");
			Category cat1 = new Category("Action");
			catRepository.save(cat1);
			Category cat2 = new Category("Scifi");
			catRepository.save(cat2);

			repository.save(new Book("Demo", "Harry", 1889, "1111222", 12.99, cat1));
			repository.save(new Book("MyBook", "Larry", 1994, "111122233", 13.99, cat2));

			User user1 = new User("user", "$2a$10$RfP8uxH.GyPHAEEdcWk3P.5tWNktP1/I2xisPQQRo.4B.o/Q86aJa",
					"user.test@email.com", "USER");
			User user2 = new User("admin", "$2a$10$ERVLMcBxsIkgHwW8SYdAfuqg2OIDQQ/oB9h7f.WaD76hYeNfCYSy6",
					"admin.test@email.com", "ADMIN");
			uRepository.save(user1);
			uRepository.save(user2);

			log.info("Fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
