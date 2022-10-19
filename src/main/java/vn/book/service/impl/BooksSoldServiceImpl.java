package vn.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.book.model.Book;
import vn.book.model.BooksSold;
import vn.book.repository.IBooksSoldRepository;
import vn.book.service.IBooksSoldService;

@Service
public class BooksSoldServiceImpl implements IBooksSoldService {

    @Autowired
    private IBooksSoldRepository booksSoldRepository;

    @Override
    public void save(BooksSold booksSold) {
        booksSoldRepository.save(booksSold);
    }
}
