package vn.edu.iuh.fit.se.thubonggiareapis.converter;

import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.PromotionDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Promotion;

@Component
public class PromotionConverter {
    public Promotion toEntity(PromotionDTO promotionDTO) {
        Promotion promotion;

        if (promotionDTO.getId() != 0) {
            promotion = new Promotion(promotionDTO.getId());
        } else {
            promotion = new Promotion();
        }

        promotion.setDeducted(promotionDTO.getDeducted());
        promotion.setExpiredDate(promotionDTO.getExpiredDate());
        promotion.setLimit(promotionDTO.getLimit());
        promotion.setPromotionCode(promotionDTO.getPromotionCode());

        return promotion;
    }

    public PromotionDTO toDto(Promotion promotion) {
        PromotionDTO promotionDTO = new PromotionDTO();

        if (promotion.getId() != 0) {
            promotionDTO.setId(promotion.getId());
        }

        promotionDTO.setDeducted(promotion.getDeducted());
        promotionDTO.setExpiredDate(promotion.getExpiredDate());
        promotionDTO.setLimit(promotion.getLimit());
        promotionDTO.setCreatedBy(promotion.getCreatedBy().getId());
        promotionDTO.setPromotionCode(promotion.getPromotionCode());

        return promotionDTO;
    }

}
