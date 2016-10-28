	package en.haagahelia.course.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import en.haagahelia.course.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findByAuthor(String author);
	List<Book> findByYear(int year);
}
