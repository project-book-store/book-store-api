package vn.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.book.dto.BooksSoldDto;
import vn.book.model.BooksSold;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IBooksSoldDtoRepository extends JpaRepository<BooksSold, Integer> {
    @Query(value = "select *, sum(quantity) as quantityBook from books_sold group by customer_id order by quantityBook desc limit 10", nativeQuery = true)
    List<BooksSoldDto> findAllQuantityBook();

    @Query(value = "select *, sum(quantity) as quantityBook from books_sold group by book_id order by quantityBook desc limit 10", nativeQuery = true)
    List<BooksSoldDto> findAllQuantityBooksSold();
}
