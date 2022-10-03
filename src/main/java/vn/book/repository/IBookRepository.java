package vn.book.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.book.model.Book;

public interface IBookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "SELECT * FROM book where is_delete = 0 and category_id = :id", nativeQuery = true,
           countQuery = "select count(*) from book where is_delete = 0 and category_id = :id")
    Page<Book> findAllBook(Pageable pageable, @Param("id") int id);
}
