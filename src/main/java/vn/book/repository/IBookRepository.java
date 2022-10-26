package vn.book.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.book.model.Book;
import vn.book.model.BooksSold;
import vn.book.model.Category;
import vn.book.model.Promotion;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
public interface IBookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "SELECT * FROM book where is_delete = 0 and category_id = :id", nativeQuery = true,
           countQuery = "select count(*) from book where is_delete = 0 and category_id = :id")
    Page<Book> findAllBook(Pageable pageable, @Param("id") int id);

    @Query(value = "select b.* from book b join books_sold bs on bs.book_id = b.id group by b.id", nativeQuery = true,
            countQuery = "select count (b.*) from book b join books_sold bs on bs.book_id = b.id group by b.id")
    Page<Book> findAllBestSellingBook(Pageable pageable);

    @Query(value = "select b.*, bs.customer_id from book b join books_sold bs on bs.id = b.id where bs.customer_id =:customerId", nativeQuery = true,
            countQuery = "select count (b.*, bs.customer_id) from book b join books_sold bs on bs.id = b.id where bs.customer_id =:customerId")
    Page<Book> findAllHistoryBook(Pageable pageable, @Param("customerId") int customerId);

    @Query(value = "SELECT * FROM book where is_delete = 0 and name_book like :keySearch", nativeQuery = true,
            countQuery = "select count(*) from book where is_delete = 0 and name_book like :keySearch")
    Page<Book> getAllBook(Pageable pageable, @Param("keySearch") String keySearch);

    @Modifying
    @Query(value = "update book set is_delete = 1 where id = :id", nativeQuery = true)
    void deleteByIdBook(@Param("id") int id);

    @Modifying
    @Query(value = "update book set book_code =:bookCode, name_book =:nameBook, images =:images, author =:author, translator =:translator, publishing_company =:publishingCompany, " +
            " number_pages =:numberPages, `size` =:size, release_date =:releaseDate, price =:price, amount =:amount, category_id =:category, promotion_id =:promotion where id =:id",  nativeQuery = true)
    void editBook(@Param("bookCode") String bookCode, @Param("nameBook") String nameBook, @Param("images") String images, @Param("author") String author, @Param("translator") String translator, @Param("publishingCompany") String publishingCompany,
                  @Param("numberPages") int numberPages, @Param("size") String size, @Param("releaseDate") LocalDate releaseDate, @Param("price") double price
            , @Param("amount") int amount, @Param("category") Category category, @Param("promotion") Promotion promotion, @Param("id") int id);
}
