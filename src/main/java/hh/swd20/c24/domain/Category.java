package hh.swd20.c24.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoryId;
	private String name;

	public Category(String name) {
		super();
		this.name = name;
	}

	public Category() {
		super();
		this.name = "";
	}

	public Long getId() {
		return categoryId;
	}

	public void setId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [id=" + categoryId + ", name=" + name + "]";
	}

}
