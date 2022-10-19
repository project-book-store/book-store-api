package vn.book.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.book.model.Book;
import vn.book.model.BooksSold;

public interface IBooksSoldService {

    void save(BooksSold booksSold);
}
