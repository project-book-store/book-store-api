package vn.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.book.model.Promotion;
import vn.book.repository.IPromotionRepository;
import vn.book.service.IPromotionService;

@Service
public class PromotionServiceImpl implements IPromotionService {

    @Autowired
    private IPromotionRepository promotionRepository;

    @Override
    public Page<Promotion> getAllPromotion(Pageable pageable, String keySearch) {
        return promotionRepository.getAllPromotion(pageable, "%" + keySearch + "%");
    }
}
