package vn.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.book.model.Card;
import vn.book.repository.ICardRepository;
import vn.book.service.ICardService;

@Service
public class CardServiceImpl implements ICardService {

    @Autowired
    private ICardRepository cardRepository;

    @Override
    public void save(Card card) {
        cardRepository.save(card);
    }
}
