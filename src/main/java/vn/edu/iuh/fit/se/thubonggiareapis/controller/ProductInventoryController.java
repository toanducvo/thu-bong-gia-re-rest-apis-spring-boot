package vn.edu.iuh.fit.se.thubonggiareapis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.ProductInventoryDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IProductInventoryService;

@RestController
public class ProductInventoryController {

    @Autowired
    private IProductInventoryService productInventoryService;

    @GetMapping(
            value = "/productInventory"
    )
    public ProductInventoryDTO getProductInventoryByProductId(@RequestParam(value = "productId") Long id) {
        return productInventoryService.getProductInventory(id);
    }

    @PutMapping(value = "/productInventory", consumes = {
            "application/x-www-form-urlencoded",
            "application/json"
    })
    public void updateProductInventory(@RequestBody ProductInventoryDTO productInventoryDTO) {
        productInventoryService.updateProductInventory(productInventoryDTO);

    }
}
