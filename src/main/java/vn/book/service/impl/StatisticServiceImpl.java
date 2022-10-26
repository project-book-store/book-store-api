package vn.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.book.dto.BooksSoldDto;
import vn.book.model.BooksSold;
import vn.book.model.Customer;
import vn.book.repository.IBooksSoldDtoRepository;
import vn.book.repository.IBooksSoldRepository;
import vn.book.repository.ICustomerRepository;
import vn.book.service.IBooksSoldService;
import vn.book.service.ICustomerService;
import vn.book.service.IStatisticService;

import java.util.List;

@Service
public class StatisticServiceImpl implements IStatisticService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private IBooksSoldDtoRepository booksSoldDtoRepository;


    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAllCustomer();
    }

    @Override
    public List<BooksSoldDto> findAllQuantityBook() {
        return booksSoldDtoRepository.findAllQuantityBook();
    }
}
