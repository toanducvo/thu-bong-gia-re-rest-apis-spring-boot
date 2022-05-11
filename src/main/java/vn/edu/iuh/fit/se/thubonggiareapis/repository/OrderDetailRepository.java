package vn.edu.iuh.fit.se.thubonggiareapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.OrderDetail;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findAllByOrder(Long orderId);
}
