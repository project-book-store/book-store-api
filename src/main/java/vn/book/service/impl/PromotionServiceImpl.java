package vn.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.book.model.Promotion;
import vn.book.repository.IPromotionRepository;
import vn.book.service.IPromotionService;

import java.util.List;
import java.util.Optional;

@Service
public class PromotionServiceImpl implements IPromotionService {

    @Autowired
    private IPromotionRepository promotionRepository;

    @Override
    public Page<Promotion> getAllPromotion(Pageable pageable, String keySearch) {
        return promotionRepository.getAllPromotion(pageable, "%" + keySearch + "%");
    }

    @Override
    public void save(Promotion promotion) {
        promotionRepository.save(promotion);
    }

    @Override
    public Optional<Promotion> findById(int id) {
        return promotionRepository.findById(id);
    }

    @Override
    public void deleteByIdPromotion(int id) {
        promotionRepository.deleteByIdPromotion(id);
    }

    @Override
    public void editPromotion(Promotion promotion) {
        promotionRepository.editPromotion(promotion.getPromotionName(), promotion.getPromotionCode(), promotion.getPromotionPrice(),
                promotion.getEndDate(), promotion.getStartDate(), promotion.getId());
    }

    @Override
    public List<Promotion> findByAll() {
        return promotionRepository.findAll();
    }
}
