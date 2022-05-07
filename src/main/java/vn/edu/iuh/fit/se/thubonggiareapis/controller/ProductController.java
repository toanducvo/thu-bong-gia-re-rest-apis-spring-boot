package vn.edu.iuh.fit.se.thubonggiareapis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.iuh.fit.se.thubonggiareapis.dto.ProductDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IProductService;

@RestController
public class ProductController {
	@Autowired
	private IProductService productService;
	
	
	@PostMapping(value = "/products", consumes = MediaType.ALL_VALUE)
	public ProductDTO addProduct(@RequestBody ProductDTO model) {
		return productService.addProduct(model);
	}
	
	@GetMapping(value = "/products", consumes = MediaType.ALL_VALUE)
	public List<ProductDTO> getProducts() {
		return productService.getProducts();
	}
}
