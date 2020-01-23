package org.ron.beautiful_monolith.domain.order.service;

import org.ron.beautiful_monolith.common.service.BaseService;
import org.ron.beautiful_monolith.domain.order.entity.Order;
import org.ron.beautiful_monolith.domain.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends BaseService<Order, Long> {
    public OrderService(OrderRepository orderRepository) {
        super(orderRepository);
    }

    @Override
    public Order find(Long id) {
        return super.find(id);
    }
}
