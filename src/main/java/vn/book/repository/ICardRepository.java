package vn.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.book.model.Card;

public interface ICardRepository extends JpaRepository<Card, Integer> {
}
