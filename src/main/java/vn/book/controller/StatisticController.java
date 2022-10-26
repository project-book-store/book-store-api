package vn.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.book.dto.BooksSoldDto;
import vn.book.model.BooksSold;
import vn.book.model.Customer;
import vn.book.service.IStatisticService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/public")
public class StatisticController {

    @Autowired
    private IStatisticService statisticService;

    @GetMapping("/statistic/customer")
    public ResponseEntity<List<Customer>> getAllCustomerName() {
         List<Customer> customerList = statisticService.findAllCustomer();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @GetMapping("/statistic/quantityBook")
    public ResponseEntity<List<BooksSoldDto>> getAllQuantityBook() {
        List<BooksSoldDto> booksSoldDtos = statisticService.findAllQuantityBook();
        return new ResponseEntity<>(booksSoldDtos, HttpStatus.OK);
    }
}
