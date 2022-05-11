package vn.edu.iuh.fit.se.thubonggiareapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    Promotion findByPromotionCode(String promotionCode);
}
