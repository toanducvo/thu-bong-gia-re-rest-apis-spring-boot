package vn.edu.iuh.fit.se.thubonggiareapis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.se.thubonggiareapis.converter.CartConverter;
import vn.edu.iuh.fit.se.thubonggiareapis.converter.CartDetailConverter;
import vn.edu.iuh.fit.se.thubonggiareapis.converter.ProductConverter;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.CartDetailDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Cart;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.CartDetail;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Product;
import vn.edu.iuh.fit.se.thubonggiareapis.repository.CartDetailRepository;
import vn.edu.iuh.fit.se.thubonggiareapis.service.ICartDetailService;
import vn.edu.iuh.fit.se.thubonggiareapis.service.ICartService;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IProductService;

import java.util.List;

@Service
public class CartDetailServiceImpl implements ICartDetailService {

    @Autowired
    private CartDetailRepository cartDetailRepository;

    @Autowired
    private CartDetailConverter cartDetailConverter;

//    @Autowired
//    private CartConverter cartConverter;
//
//    @Autowired
//    private ICartService cartService;

    @Autowired
    private IProductService productService;

    @Autowired
    private ProductConverter productConverter;

    @Override
    public void addProductsToCart(CartDetailDTO cartDetailDTO) {
        CartDetail cartDetail = cartDetailConverter.toEntity(cartDetailDTO);
        System.out.println(cartDetail);
        cartDetailRepository.save(cartDetail);
    }

    @Override
    @Transactional
    public void deleteProductWithToken(String token, long productId) {

//        Cart cart = cartConverter.toEntity(
//                cartService.getCartByToken(token)
//        );
//        Product product = productConverter.toEntity(
//          productService.getProductById(productId)
//        );
//
//        System.out.println(cart);
//        System.out.println(product);
//        cartDetailRepository.deleteByCartAndProduct(cart, product);
    }

    @Override
    public List<CartDetailDTO> getCartDetailsByToken(String token) {
        List<CartDetail> cartDetails = cartDetailRepository.findCartDetailByCartToken(token);
        return cartDetailConverter.toDtos(cartDetails);
    }
}
