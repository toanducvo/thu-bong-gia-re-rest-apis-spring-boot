package vn.edu.iuh.fit.se.thubonggiareapis.service;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.CartDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.CartDetailDTO;

import java.util.List;

@Service
public interface ICartDetailService {
    void addProductsToCart(CartDetailDTO cartDetailDTO);

    void deleteProductWithToken(String token, long productId);
}
