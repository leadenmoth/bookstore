package en.haagahelia.course.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import en.haagahelia.course.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	List<Category> findByName(String name);

}
