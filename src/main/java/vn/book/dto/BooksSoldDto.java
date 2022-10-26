package vn.book.dto;

import vn.book.model.Book;
import vn.book.model.Customer;

public interface BooksSoldDto {
    Integer getId();

    Integer getQuantity();

    Book getBook();

    Customer getCustomer();

    Integer getQuantityBook();
}
