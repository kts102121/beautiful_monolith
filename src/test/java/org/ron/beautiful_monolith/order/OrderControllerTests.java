package org.ron.beautiful_monolith.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.ron.beautiful_monolith.domain.order.dto.OrderDTO;
import org.ron.beautiful_monolith.domain.order.entity.Order;
import org.ron.beautiful_monolith.domain.order.repository.OrderRepository;
import org.ron.beautiful_monolith.domain.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderRepository orderRepository;

    @BeforeEach
    public void init() {
        Order order = Order.builder()
                .productName("iPhone8")
                .build();

        Order order1 = Order.builder()
                .productName("iPhoneX")
                .build();

        List<Order> orders = new ArrayList<>();
        orders.add(order);
        orders.add(order1);

        orderRepository.saveAll(orders);
    }

    @Test
    public void findAll() throws Exception {
        this.mockMvc.perform(get("/orders")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].productName", is("iPhone8")))
                .andExpect(jsonPath("$[1].productName", is("iPhoneX")));
    }
}
