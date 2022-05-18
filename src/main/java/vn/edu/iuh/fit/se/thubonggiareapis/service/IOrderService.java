package vn.edu.iuh.fit.se.thubonggiareapis.service;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.OrderDTO;

import java.time.Month;
import java.util.List;

@Service
public interface IOrderService {
    List<OrderDTO> getAllOrders();

    OrderDTO getOrderById(Long orderId);

    OrderDTO addOrder(OrderDTO order);

    List<OrderDTO> getOrdersByOrderDate(int year, int month, int dayOfMonth);
}
