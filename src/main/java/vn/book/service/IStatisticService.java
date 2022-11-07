package vn.book.service;

import vn.book.dto.BooksSoldDto;
import vn.book.model.Book;
import vn.book.model.BooksSold;
import vn.book.model.Customer;

import java.util.List;

public interface IStatisticService {

    List<Customer> findAllCustomer();

    List<Book> findAllBook();

    List<BooksSoldDto> findAllQuantityBook();

    List<BooksSoldDto> findAllQuantityBooksSold();
}
