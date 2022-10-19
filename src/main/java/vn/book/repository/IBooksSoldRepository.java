package vn.book.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.book.model.BooksSold;

public interface IBooksSoldRepository extends JpaRepository<BooksSold, Integer> {
}
