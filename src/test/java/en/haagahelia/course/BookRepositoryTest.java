package en.haagahelia.course;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import en.haagahelia.course.domain.Category;
import en.haagahelia.course.domain.Book;
import en.haagahelia.course.domain.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;
   
    @Test
    public void findByAuthorShouldReturnBook() {
        List<Book> books = repository.findByAuthor("Eoin Colfer");
    	//List<Book> books = repository.findByYear(1982);
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("And Another Thing...");
    }
    
    @Test
    public void createNewBook() {
    	Book book = new Book("Mickey Mouse", "Walt Disney", 1928, "98764325405", 0.99, new Category("Script"));
    	repository.save(book);
    	assertThat(repository.findOne(book.getId())).isNotNull();
    } 
    

    
    @Test
    public void deleteBook() {
        List<Book> books = repository.findByAuthor("Douglas Adams");
        repository.delete(books.get(0).getId());
        assertThat(repository.findOne(books.get(0).getId()) == null);
        
    }
    
   

}