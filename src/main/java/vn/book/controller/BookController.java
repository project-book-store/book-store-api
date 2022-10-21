package vn.book.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.book.model.Book;
import vn.book.model.Promotion;
import vn.book.service.IBookService;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/public")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("/book/{id}")
    public ResponseEntity<Page<Book>> getAllBook(@PageableDefault(value = 9) Pageable pageable,
                                                 @PathVariable int id) {
        Page<Book> books = bookService.findAllBook(pageable, id);
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("book/detail/{id}")
    public ResponseEntity<Optional<Book>> getBook(@PathVariable int id) {
        Optional<Book> book = bookService.findById(id);
        if (!book.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/bestSellingBook")
    public ResponseEntity<Page<Book>> getBestSellingBook(@PageableDefault(value = 9) Pageable pageable) {
        Page<Book> books = bookService.findAllBestSellingBook(pageable);
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/historyBook/{customerId}")
    public ResponseEntity<Page<Book>> getAllHistoryBook(@PageableDefault(value = 9) Pageable pageable,
                                                 @PathVariable int customerId) {
        Page<Book> books = bookService.findAllHistoryBook(pageable, customerId);
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/book/list")
    public ResponseEntity<Page<Book>> getAllBook(@PageableDefault(value = 5) Pageable pageable, Optional<String> keySearch) {
        String title = keySearch.orElse("");
        if (title.equals("null")) {
            title = "";
        }
        Page<Book> bookPage = bookService.getAllBook(pageable, title);
        if (bookPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookPage, HttpStatus.OK);
    }

    @PutMapping(value = "/book/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable String id) {
        try {
            Integer.parseInt(id);
            Optional<Book> book = bookService.findById(Integer.parseInt(id));
            if (!book.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            bookService.deleteByIdBook(Integer.parseInt(id));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (final Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/book/create")
    public ResponseEntity<?> createBook(@RequestBody Book book) {
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        book.setReleaseDate(LocalDate.now());
        this.bookService.save(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findByIdBook/{id}")
    public ResponseEntity<Optional<Book>> getByIdBook(@PathVariable int id) {
        Optional<Book> book = bookService.findById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping("/book/edit")
    public ResponseEntity<?> editBook(@RequestBody Book book) {
        bookService.editBook(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
