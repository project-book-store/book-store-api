package vn.book.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.book.model.Promotion;

public interface IPromotionService {
    Page<Promotion> getAllPromotion(Pageable pageable, String keySearch);
}
