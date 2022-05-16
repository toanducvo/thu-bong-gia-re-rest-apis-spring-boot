package vn.edu.iuh.fit.se.thubonggiareapis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.PromotionDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IPromotionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/promotions")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PromotionController {

    @Autowired
    private IPromotionService promotionService;

    @GetMapping(value = {
            "", "/"
    })
    public List<PromotionDTO> getPromotions() {
        return promotionService.getAllPromotions();
    }

    @PostMapping(value = {"", "/"}, consumes = MediaType.ALL_VALUE)
    public PromotionDTO addPromotion(@RequestBody PromotionDTO model) {
        return promotionService.addPromotion(model);
    }

    @GetMapping("/{promotionId}")
    public PromotionDTO getPromotion(@PathVariable long promotionId) {
        return promotionService.getPromotion(promotionId);
    }


    @PutMapping(value = "/promotions", consumes = MediaType.ALL_VALUE)
    public void updatePromotion(@RequestBody PromotionDTO model) {
        promotionService.updatePromotion(model);
    }

    @GetMapping("/promotionCode")
    public PromotionDTO getPromotionByPromotionCode(@RequestParam(name = "promotionCode", required = false) Optional<String> promotionCode) {
        return promotionService.getPromotionByCode(promotionCode.get());
    }
}
