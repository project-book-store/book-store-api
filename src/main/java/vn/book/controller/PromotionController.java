package vn.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.book.model.Promotion;
import vn.book.service.IPromotionService;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/public")
public class PromotionController {

    @Autowired
    private IPromotionService promotionService;

    @GetMapping("/promotion")
    public ResponseEntity<Page<Promotion>> getAllTreatment(@PageableDefault(value = 5) Pageable pageable, Optional<String> keySearch) {
        String title = keySearch.orElse("");
        if (title.equals("null")) {
            title = "";
        }
        Page<Promotion> promotionPage = promotionService.getAllPromotion(pageable, title);
        if (promotionPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(promotionPage, HttpStatus.OK);
    }
}
