package vn.book.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.book.model.Book;
import vn.book.model.BooksSold;

import java.util.Optional;

public interface IBookService {

    Page<Book> findAllBook(Pageable pageable, int id);

    Optional<Book> findById(int id);

    void save(Book book);

    Page<Book> findAllBestSellingBook(Pageable pageable);

    Page<Book> findAllHistoryBook(Pageable pageable, int customerId);
}
