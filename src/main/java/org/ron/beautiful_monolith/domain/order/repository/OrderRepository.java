package org.ron.beautiful_monolith.domain.order.repository;

import org.ron.beautiful_monolith.domain.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
