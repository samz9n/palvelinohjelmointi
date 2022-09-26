package hh.swd20.c24.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category, Long> {
	List<Category> findByName(String name);
}
