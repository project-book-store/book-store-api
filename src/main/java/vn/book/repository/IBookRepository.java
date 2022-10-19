package vn.book.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.book.model.Book;
import vn.book.model.BooksSold;

public interface IBookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "SELECT * FROM book where is_delete = 0 and category_id = :id", nativeQuery = true,
           countQuery = "select count(*) from book where is_delete = 0 and category_id = :id")
    Page<Book> findAllBook(Pageable pageable, @Param("id") int id);

    @Query(value = "select b.* from book b join books_sold bs on bs.id = b.id", nativeQuery = true,
            countQuery = "select count (b.*) from join books_sold bs on bs.id = b.id")
    Page<Book> findAllBestSellingBook(Pageable pageable);

    @Query(value = "select b.*, bs.customer_id from book b join books_sold bs on bs.id = b.id where bs.customer_id =:customerId", nativeQuery = true,
            countQuery = "select count (b.*, bs.customer_id) from book b join books_sold bs on bs.id = b.id where bs.customer_id =:customerId")
    Page<Book> findAllHistoryBook(Pageable pageable, @Param("customerId") int customerId);
}
