package vn.edu.iuh.fit.se.thubonggiareapis.service;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.OrderDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.OrderDetailDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Order;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.OrderDetail;

import java.util.List;

@Service
public interface IOrderDetailService {
    Double addOrderDetail(Order orderDTO, List<OrderDetailDTO> details);
    List<OrderDetailDTO> getOrderDetailByOrderId (Long orderId);
}
