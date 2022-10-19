package vn.book.service;

import vn.book.model.Customer;

import java.util.List;

public interface ICustomerService {
    void save(Customer customer);

    List<Customer> findAllCustomer();

    Customer findByUserId(int AppUserId);

    void edit(int id, Customer customer);
}
