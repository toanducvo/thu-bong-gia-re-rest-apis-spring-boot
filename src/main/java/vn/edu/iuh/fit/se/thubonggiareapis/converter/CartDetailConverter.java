package vn.edu.iuh.fit.se.thubonggiareapis.converter;

import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.CartDetailDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Cart;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.CartDetail;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Product;

@Component
public class CartDetailConverter {
    public CartDetail toEntity(CartDetailDTO cartDetailDTO) {
        return new CartDetail(
                new Product(cartDetailDTO.getProduct()),
                new Cart(cartDetailDTO.getCart()),
                cartDetailDTO.getQuantity(),
                cartDetailDTO.getCost(),
                cartDetailDTO.getQuantity() * cartDetailDTO.getCost()
        );
    }

    public CartDetailDTO toDto(CartDetail cartDetail) {
        return new CartDetailDTO(
                cartDetail.getCart().getToken(),
                cartDetail.getQuantity(),
                cartDetail.getCost(),
                cartDetail.getQuantity() * cartDetail.getCost()
        );
    }
}
