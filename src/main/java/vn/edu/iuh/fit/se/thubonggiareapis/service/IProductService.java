package vn.edu.iuh.fit.se.thubonggiareapis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.edu.iuh.fit.se.thubonggiareapis.dto.ProductDTO;

@Service
public interface IProductService {
	ProductDTO addProduct(ProductDTO productDTO);
	List<ProductDTO> getProducts();
}
