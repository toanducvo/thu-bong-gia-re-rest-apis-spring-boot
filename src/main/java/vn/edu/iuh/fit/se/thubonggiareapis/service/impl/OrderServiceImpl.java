package vn.edu.iuh.fit.se.thubonggiareapis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.thubonggiareapis.converter.*;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.OrderDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.OrderDetailDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Order;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.OrderDetail;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Promotion;
import vn.edu.iuh.fit.se.thubonggiareapis.repository.OrderRepository;
import vn.edu.iuh.fit.se.thubonggiareapis.service.*;

import java.time.LocalDateTime;
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
    private IProductService productService;

    @Autowired
    private ProductConverter productConverter;

    @Autowired
    private IOrderDetailService orderDetailService;


    @Autowired
    private OrderDetailConverter orderDetailConverter;

    @Override
    public List<OrderDTO> getAllOrders() {
        List<OrderDTO> orders = new ArrayList<>();
        orderRepository.findAll().forEach((order -> {
            OrderDTO orderDTO = orderConverter.toDTO(order);
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
        return orderConverter.toDTO(result);
    }

    @Override
    public OrderDTO addOrder(OrderDTO orderDTO) {
        Order order = orderConverter.toEntity(orderDTO);

        order.setPromotion(
                orderDTO.getPromotionCode() == null ? null :
                promotionConverter.toPromotionEntity(
                        promotionService.getPromotionByCode(orderDTO.getPromotionCode())
                ));

        order.setCustomer(
                customerConverter.toCustomerEntity(
                        customerService.getCustomer(orderDTO.getCustomer())
                )
        );

        System.out.println(order.toString());

        orderRepository.save(order);

        order.setSubTotal(orderDetailService.addOrderDetail(order, orderDTO.getDetails()));

        order.setTotal(order.getSubTotal() + order.getShippingCost());

        if (order.getPromotion() != null) {
            order.setDiscount(order.getPromotion().getDeducted());
            order.setTotal(order.getTotal() - order.getDiscount());
        }

        orderRepository.save(order);
//        List<OrderDetail> orderDetails = new ArrayList<>();
//        List<OrderDetailDTO> orderDetailDTOS = orderDetailService.getOrderDetailByOrderId(order.getId());
//
//        for (OrderDetailDTO orderDetailDTO : orderDetailDTOS) {
//            orderDetails.add(orderDetailConverter.toEntity(orderDetailDTO));
//        }
//        order.setOrderDetails(orderDetails);

        return orderConverter.toDTO(order);
    }

}
