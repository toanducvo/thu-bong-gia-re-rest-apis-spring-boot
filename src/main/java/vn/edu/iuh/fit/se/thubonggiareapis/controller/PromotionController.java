package vn.edu.iuh.fit.se.thubonggiareapis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.PromotionDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IPromotionService;

@RestController
public class PromotionController {

    @Autowired
    private IPromotionService promotionService;

    @PostMapping(value = "/promotions", consumes = MediaType.ALL_VALUE)
    public PromotionDTO addPromotion(@RequestBody PromotionDTO model) {
        return promotionService.addPromotion(model);
    }

    @GetMapping("/promotions/{promotionId}")
    public PromotionDTO getPromotion(@PathVariable long promotionId) {
        return promotionService.getPromotion(promotionId);
    }


    @PutMapping(value = "/promotions", consumes = MediaType.ALL_VALUE)
    public void updatePromotion(@RequestBody PromotionDTO model) {
        promotionService.updatePromotion(model);
    }
}
