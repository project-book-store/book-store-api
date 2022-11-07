package vn.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.book.model.Customer;
import vn.book.repository.ICustomerRepository;
import vn.book.service.ICustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findByUserId(int userId) {
        return customerRepository.findByUserId(userId);
    }

    @Override
    public void edit(int id, Customer customer) {
        customerRepository.editCustomer(customer.getAddress(), customer.getCustomerName(), customer.getNote(), customer.getPhoneNumber(), customer.getImages(), customer.getDateOfBirth(), id);
    }
}
