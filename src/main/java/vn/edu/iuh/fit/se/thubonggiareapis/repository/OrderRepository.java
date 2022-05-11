package vn.edu.iuh.fit.se.thubonggiareapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
