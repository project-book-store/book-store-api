package vn.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.book.model.Book;
import vn.book.model.BooksSold;
import vn.book.repository.IBookRepository;
import vn.book.service.IBookService;

import java.util.Optional;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Page<Book> findAllBook(Pageable pageable, int id) {
        return bookRepository.findAllBook(pageable, id);
    }

    @Override
    public Optional<Book> findById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public void save(Book book) {

    }

    @Override
    public Page<Book> findAllBestSellingBook(Pageable pageable) {
        return bookRepository.findAllBestSellingBook(pageable);
    }

    @Override
    public Page<Book> findAllHistoryBook(Pageable pageable, int customerId) {
        return bookRepository.findAllHistoryBook(pageable, customerId);
    }
}
