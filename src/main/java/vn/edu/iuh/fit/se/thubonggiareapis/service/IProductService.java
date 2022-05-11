package vn.edu.iuh.fit.se.thubonggiareapis.service;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.ProductDTO;

import java.util.List;

@Service
public interface IProductService {
    ProductDTO addProduct(ProductDTO productDTO);

    List<ProductDTO> getProducts();

    ProductDTO getProductById(Long productId);
}
