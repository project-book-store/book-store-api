package vn.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.book.model.AppUser;
import vn.book.model.Customer;
import vn.book.service.impl.CustomerServiceImpl;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/public")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @PutMapping("/customer/update")
    public ResponseEntity<?> editCustomer(@RequestBody @Valid Customer customer) {
        customerService.edit(customer.getId(), customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/customer/{userId}")
    public ResponseEntity<Customer> getUser(@PathVariable int userId) {
        Customer customer = customerService.findByUserId(userId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
