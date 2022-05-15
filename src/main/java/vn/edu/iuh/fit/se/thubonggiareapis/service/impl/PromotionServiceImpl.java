package vn.edu.iuh.fit.se.thubonggiareapis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.thubonggiareapis.converter.PromotionConverter;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.PromotionDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Promotion;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.User;
import vn.edu.iuh.fit.se.thubonggiareapis.repository.PromotionRepository;
import vn.edu.iuh.fit.se.thubonggiareapis.repository.UserRepository;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IPromotionService;

import java.util.List;
import java.util.Objects;

@Service
public class PromotionServiceImpl implements IPromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PromotionConverter promotionConverter;

    @Override
    public PromotionDTO addPromotion(PromotionDTO promotionDTO) {
        Promotion promotion = promotionConverter.toEntity(promotionDTO);
        User user = userRepository.getById(promotionDTO.getCreatedBy());
        promotion.setCreatedBy(user);
        promotionRepository.save(promotion);
        return promotionConverter.toDto(promotion);
    }

    @Override
    public PromotionDTO getPromotion(long id) {
        Promotion promotion = promotionRepository.getById(id);
        return promotionConverter.toDto(promotion);
    }

    @Override
    public void updatePromotion(PromotionDTO promotionDTO) {
        // TODO Auto-generated method stub
        Promotion promotion = promotionConverter.toEntity(promotionDTO);
        User user = userRepository.getById(promotionDTO.getCreatedBy());
        promotion.setCreatedBy(user);
        System.out.println("entity:" + promotion);
        promotionRepository.save(promotion);
    }

    @Override
    public PromotionDTO getPromotionByCode(String promotionCode) {
        Promotion promotion = promotionRepository.findByPromotionCode(promotionCode);
        if (Objects.isNull(promotion)) {
            return null;
        }
        return promotionConverter.toDto(promotion);
    }

    @Override
    public List<PromotionDTO> getAllPromotions() {
        List<Promotion> promotions = promotionRepository.findAll();
        return promotionConverter.toDtos(promotions);
    }


}
