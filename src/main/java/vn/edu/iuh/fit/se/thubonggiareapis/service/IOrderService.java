package vn.edu.iuh.fit.se.thubonggiareapis.service;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.OrderDTO;

import java.util.List;

@Service
public interface IOrderService {
    List<OrderDTO> getAllOrders();

    OrderDTO getOrderById(Long orderId);

    void addOrder(OrderDTO order);
}
