package vn.edu.iuh.fit.se.thubonggiareapis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.PromotionDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IPromotionService;

import java.util.HashMap;
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
        return promotionCode.map(s -> promotionService.getPromotionByCode(s)).orElse(null);
    }

    @GetMapping(value = {
            "/stats", "/stats/"
    })
    public ResponseEntity<HashMap<String, Object>> getStats() {
        HashMap<String, Object> response = new HashMap<>();
        try {
            long expired = promotionService.getExpiredPromotions();
            long total = promotionService.getTotalPromotion();

            response.put("expiredPromotion", expired);
            response.put("totalPromotion", total);
            response.put("inDueDatePromotion", total - expired);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
