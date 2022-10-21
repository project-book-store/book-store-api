package vn.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.book.model.Category;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
