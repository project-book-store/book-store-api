package vn.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.book.model.Promotion;
import vn.book.service.IPromotionService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/public")
public class PromotionController {

    @Autowired
    private IPromotionService promotionService;

    @GetMapping("/promotion")
    public ResponseEntity<Page<Promotion>> getAllPromotion(@PageableDefault(value = 5) Pageable pageable, Optional<String> keySearch) {
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

    @PutMapping(value = "/promotion/{id}")
    public ResponseEntity<Void> deletePromotion(@PathVariable String id) {
        try {
            Integer.parseInt(id);
            Optional<Promotion> promotion = promotionService.findById(Integer.parseInt(id));
            if (!promotion.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            promotionService.deleteByIdPromotion(Integer.parseInt(id));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (final Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/promotion/create")
    public ResponseEntity<?> createPromotion(@RequestBody Promotion promotion) {
        if (promotion == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        this.promotionService.save(promotion);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/promotion/{id}")
    public ResponseEntity<Optional<Promotion>> getPromotion(@PathVariable int id) {
        Optional<Promotion> promotion = promotionService.findById(id);
        return new ResponseEntity<>(promotion, HttpStatus.OK);
    }

    @PutMapping("/promotion/edit")
    public ResponseEntity<?> editPromotion(@RequestBody Promotion promotion) {
        promotionService.editPromotion(promotion);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/promotion/list")
    public ResponseEntity<List<Promotion>> getAllPromotion() {
        List<Promotion> promotions = promotionService.findByAll();
        return new ResponseEntity<>(promotions, HttpStatus.OK);
    }
}
