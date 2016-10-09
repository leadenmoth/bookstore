package en.haagahelia.course;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import en.haagahelia.course.domain.Book;
import en.haagahelia.course.domain.BookRepository;
import en.haagahelia.course.domain.Category;
import en.haagahelia.course.domain.CategoryRepository;
import en.haagahelia.course.domain.UserRepository;
import en.haagahelia.course.domain.User;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			crepository.save(new Category("SciFi"));
			crepository.save(new Category("Documentary"));
			crepository.save(new Category("Mystery"));
			crepository.save(new Category("Thriller"));
			
			repository.save(new Book("Douglas Adams", "The Hitchhiker's Guide to the Galaxy", 1979, "0-330-25864-8", 9.99, crepository.findByName("SciFi").get(0)));
			repository.save(new Book("Douglas Adams", "The Restaurant at the End of the Universe", 1980, "0-345-39181-0", 9.99, crepository.findByName("SciFi").get(0)));
			repository.save(new Book("Douglas Adams", "Life, the Universe and Everything", 1982, "0-330-26738-8", 9.99, crepository.findByName("SciFi").get(0)));
			repository.save(new Book("Douglas Adams", "So Long, and Thanks for All the Fish", 1984, "0-330-28700-1", 9.99, crepository.findByName("SciFi").get(0)));
			repository.save(new Book("Douglas Adams", "Mostly Harmless", 1992, "0-330-32311-3", 9.99, crepository.findByName("SciFi").get(0)));
			repository.save(new Book("Eoin Colfer", "And Another Thing...", 2009, "978-1-4013-2358-5", 9.99, crepository.findByName("SciFi").get(0)));
			
			//Passwords are 'password'
			urepository.save(new User("user", "$2a$04$38PefzLvW0TjewRTUBGlB.CAkQmxHVYgwxqT.GT3w/r6MPEV/K1Jq", "user@mail.fi", "USER"));
			urepository.save(new User("admin", "$2a$04$M0hCFefLmgOnhRkg9zr9Y.OMhCbtk.ImhVIuWCog.LOIyOw280G4O", "admin@mail.fi", "ADMIN"));
		};
	}

}
