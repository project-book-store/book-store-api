package vn.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.book.model.BooksSold;

public interface IBooksSoldRepository extends JpaRepository<BooksSold, Integer> {
}
