package vn.edu.iuh.fit.se.thubonggiareapis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.iuh.fit.se.thubonggiareapis.dto.ProductInventoryDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IProductInventoryService;

@RestController
public class ProductInventoryController {
	
	@Autowired
	private IProductInventoryService productInventoryService;
	
	@PutMapping(value = "/productInventory", consumes = MediaType.ALL_VALUE)
	public void updateProductInventory(@RequestBody ProductInventoryDTO productInventoryDTO) {
		productInventoryService.updateProductInventory(productInventoryDTO);
		
	}
}
