package vn.edu.iuh.fit.se.thubonggiareapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Cart;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.CartDetail;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.OrderDetail;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Product;

import java.util.List;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, String> {
    OrderDetail deleteByCartAndProduct(Cart cart, Product product);
    List<CartDetail> findCartDetailByCartToken(@Param("cart_id") String token);
}
