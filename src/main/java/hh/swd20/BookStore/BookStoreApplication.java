package hh.swd20.BookStore;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import ch.qos.logback.classic.Logger;
import hh.swd20.BookStore.domain.Book;
import hh.swd20.BookStore.domain.BookRepository;
import hh.swd20.BookStore.domain.Category;
import hh.swd20.BookStore.domain.CategoryRepository;
import hh.swd20.BookStore.domain.UserRepository;


@SpringBootApplication
public class BookStoreApplication {
	private static final Logger log = (Logger) LoggerFactory.getLogger(BookStoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner categoryDemo(BookRepository bRepository , CategoryRepository cRepository, UserRepository userRepo) {
		return (args) -> {
			log.info("save a couple of books");
			cRepository.save(new Category("Drama"));
			cRepository.save(new Category("Thriller"));
			cRepository.save(new Category("Biography"));
			cRepository.save(new Category("Science"));
			cRepository.save(new Category("Psykology"));
			
			
				bRepository.save(new Book
						("Bridget Jones, Elämä jatkuu", "Helen Fielding", 1999, "978-951-1-27713-2", 6.50, cRepository.findByName("Drama").get(0)));
				bRepository.save(new Book	
						("Idiootit ympärilläni", "Thomas Erikson", 2017, "978-952-300-321-7", 17.95, cRepository.findByName("Psykology").get(0)));
				bRepository.save(new Book
						("The Crown", "Robert Lacey", 2017, "978-951-1-32191-0", 26.95, cRepository.findByName("Biography").get(0)));
			
			//Create users
			User user1 = new User("user", "user", "USER");
			User user2 = new User("admin", "admin", "ADMIN");
			userRepo.save(user1);
			userRepo.save(user2);
				
				
			log.info("fetch all books");
			for (Book book : bRepository.findAll()) {
				log.info(book.toString());
			}
		
		};
		}
	}



