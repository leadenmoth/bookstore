package en.haagahelia.course;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import en.haagahelia.course.domain.Book;
import en.haagahelia.course.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			repository.save(new Book("Douglas Adams", "The Hitchhiker's Guide to the Galaxy", 1979, "0-330-25864-8", 9.99));
			repository.save(new Book("Douglas Adams", "The Restaurant at the End of the Universe", 1980, "0-345-39181-0", 9.99));
			repository.save(new Book("Douglas Adams", "Life, the Universe and Everything", 1982, "0-330-26738-8", 9.99));
			repository.save(new Book("Douglas Adams", "So Long, and Thanks for All the Fish", 1984, "0-330-28700-1", 9.99));
			repository.save(new Book("Douglas Adams", "Mostly Harmless", 1992, "0-330-32311-3", 9.99));
			repository.save(new Book("Eoin Colfer", "And Another Thing...", 2009, "978-1-4013-2358-5", 9.99));
		};
	}
}
