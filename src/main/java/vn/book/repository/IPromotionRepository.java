package vn.book.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import vn.book.model.Promotion;

import java.time.LocalDate;

@Transactional
public interface IPromotionRepository extends JpaRepository<Promotion, Integer> {
    @Query(value = "select * from promotion "
            + "where is_delete = 0 and promotion_name like :keySearch ", nativeQuery = true,
            countQuery = "select count (*) from promotion where is_delete = 0 and promotion_name like :keySearch")
    Page<Promotion> getAllPromotion(Pageable pageable, @Param("keySearch") String keySearch);

    @Modifying
    @Query(value = "update promotion set is_delete = 1 where id = :id", nativeQuery = true)
    void deleteByIdPromotion(@Param("id") int id);

    @Modifying
    @Query(value = "update promotion set promotion_name =:promotionName, promotion_code =:promotionCode, promotion_price =:promotionPrice, " +
            " end_date =:endDate, start_date =:startDate where id =:id", nativeQuery = true)
    void editPromotion(@Param("promotionName") String promotionName, @Param("promotionCode") String promotionCode, @Param("promotionPrice") int promotionPrice,
                       @Param("endDate") LocalDate endDate, @Param("startDate") LocalDate startDate, @Param("id") int id);
}
