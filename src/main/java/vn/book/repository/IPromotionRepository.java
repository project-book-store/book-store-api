package vn.book.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.book.model.Promotion;

public interface IPromotionRepository extends JpaRepository<Promotion, Integer> {
    @Query(value = "select * from promotion "
            + "where is_delete = 0 and promotion_name like :keySearch ", nativeQuery = true,
            countQuery = "select count (*) from promotion where is_deleted = 0 and promotion_name like :keySearch")
    Page<Promotion> getAllPromotion(Pageable pageable, @Param("keySearch") String keySearch);
}
