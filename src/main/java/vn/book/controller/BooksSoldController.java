package vn.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.book.model.Book;
import vn.book.model.BooksSold;
import vn.book.service.impl.BooksSoldServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/public")
public class BooksSoldController {

    @Autowired
    private BooksSoldServiceImpl booksSoldService;

    @PostMapping("/booksSold/create")
    public ResponseEntity<?> save(@RequestBody @Valid List<BooksSold> booksSolds) {
        for (int i = 0; i < booksSolds.toArray().length; i++) {
            booksSoldService.save(booksSolds.get(i));
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
