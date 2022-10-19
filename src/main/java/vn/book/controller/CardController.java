package vn.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.book.model.Card;
import vn.book.service.impl.CardServiceImpl;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/public")
public class CardController {

    @Autowired
    private CardServiceImpl cardService;

    @PostMapping("card/create")
    public ResponseEntity<?> save(@RequestBody @Valid Card card) {
        cardService.save(card);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
