package vn.book.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.book.model.Promotion;

import java.util.List;
import java.util.Optional;

public interface IPromotionService {
    Page<Promotion> getAllPromotion(Pageable pageable, String keySearch);

    void save(Promotion promotion);

    Optional<Promotion> findById(int id);

    void deleteByIdPromotion(int id);

    void editPromotion(Promotion promotion);

    List<Promotion> findByAll();
}
