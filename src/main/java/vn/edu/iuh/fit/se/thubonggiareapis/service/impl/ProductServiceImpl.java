package vn.edu.iuh.fit.se.thubonggiareapis.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import vn.edu.iuh.fit.se.thubonggiareapis.converter.ProductConverter;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.ProductDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.ProductInventoryDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Product;
import vn.edu.iuh.fit.se.thubonggiareapis.repository.ProductRepository;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IProductInventoryService;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConverter productConverter;
	
	@Autowired
	private IProductInventoryService productInventoryService;

	@Override
	public ProductDTO addProduct(ProductDTO productDTO) {
		Product product = productConverter.toProductEntity(productDTO);
		product = productRepository.save(product);
		
		ProductInventoryDTO productInventoryDTO = new ProductInventoryDTO(0, productDTO.getCost(), LocalDateTime.now(), product.getId());
		
		productInventoryService.addProductInventory(productInventoryDTO);
		
		
		return productConverter.toProductDTO(product);
	}

	@Override
	public List<ProductDTO> getProducts() {
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		List<Product> products = productRepository.findAll();
		for (Product product : products) {
			ProductDTO productDTO = productConverter.toProductDTO(product);
			productDTOs.add(productDTO);
		}

		return productDTOs;
	}

}
