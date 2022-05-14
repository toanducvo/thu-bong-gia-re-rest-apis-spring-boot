package vn.edu.iuh.fit.se.thubonggiareapis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.thubonggiareapis.converter.CustomerConverter;
import vn.edu.iuh.fit.se.thubonggiareapis.converter.OrderConverter;
import vn.edu.iuh.fit.se.thubonggiareapis.converter.PromotionConverter;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.OrderDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.OrderDetailDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.ProductInventoryDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Order;
import vn.edu.iuh.fit.se.thubonggiareapis.repository.OrderRepository;
import vn.edu.iuh.fit.se.thubonggiareapis.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderConverter orderConverter;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private IPromotionService promotionService;

    @Autowired
    private PromotionConverter promotionConverter;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private CustomerConverter customerConverter;

    @Autowired
    private IOrderDetailService orderDetailService;

    @Autowired
    private IProductInventoryService productInventoryService;

    @Override
    public List<OrderDTO> getAllOrders() {
        List<OrderDTO> orders = new ArrayList<>();
        orderRepository.findAll().forEach((order -> {
            OrderDTO orderDTO = orderConverter.toDto(order);
            orders.add(orderDTO);
        }));
        return orders;
    }

    @Override
    public OrderDTO getOrderById(Long orderId) {
        Order result = orderRepository.findById(orderId).orElse(null);
        if (Objects.isNull(result)) {
            return null;
        }
        return orderConverter.toDto(result);
    }

    @Override
    public OrderDTO addOrder(OrderDTO orderDTO) {
        Order order = orderConverter.toEntity(orderDTO);

        order.setPromotion(
                orderDTO.getPromotionCode() == null ? null :
                        promotionConverter.toEntity(
                                promotionService.getPromotionByCode(orderDTO.getPromotionCode())
                        ));

        order.setCustomer(
                customerConverter.toEntity(
                        customerService.getCustomer(orderDTO.getCustomer())
                )
        );

        orderRepository.save(order);

        order.setSubTotal(orderDetailService.addOrderDetail(order, orderDTO.getDetails()));

        order.setTotal(order.getSubTotal() + order.getShippingCost());

        if (order.getPromotion() != null) {
            order.setDiscount(order.getPromotion().getDeducted());
            order.setTotal(order.getTotal() - order.getDiscount());
        }

        orderRepository.save(order);

        orderDTO.getDetails().forEach(
                orderDetailDTO -> productInventoryService.updateProductInventory(new ProductInventoryDTO(orderDetailDTO.getProduct(), -orderDetailDTO.getQuantity()))
        );

        List<OrderDetailDTO> orderDetailDTOs = orderDetailService.getOrderDetailByOrderId(order.getId());
        OrderDTO dto = orderConverter.toDto(order);
        dto.setDetails(orderDetailDTOs);

        return dto;
    }

}
