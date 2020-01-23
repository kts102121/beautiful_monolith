package org.ron.beautiful_monolith.domain.order.controller;

import org.ron.beautiful_monolith.common.controller.BaseRestController;
import org.ron.beautiful_monolith.common.service.DomainMapper;
import org.ron.beautiful_monolith.domain.order.dto.OrderDTO;
import org.ron.beautiful_monolith.domain.order.entity.Order;
import org.ron.beautiful_monolith.domain.order.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController extends BaseRestController<Order, OrderDTO, Long> {
    private OrderService orderService;

    public OrderController(DomainMapper domainMapper, OrderService orderService) {
        super(domainMapper, orderService);
    }
}
