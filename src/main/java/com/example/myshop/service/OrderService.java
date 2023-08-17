package com.example.myshop.service;

import com.example.myshop.Cart;
import com.example.myshop.dto.OrderDto;
import com.example.myshop.mapper.OrderMapper;
import com.example.myshop.model.order.Order;
import com.example.myshop.model.order.OrderItem;
import com.example.myshop.repository.order.OrderItemRepository;
import com.example.myshop.repository.order.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final Cart cart;

    private final OrderRepository orderRepository;

    private final OrderItemRepository orderItemRepository;

    public OrderService(Cart cart, OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.cart = cart;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public void saveOrder(OrderDto orderDto){
        Order order = OrderMapper.mapToOrder(orderDto);
        orderRepository.save(order);
        List<OrderItem> orderItems = OrderMapper.mapToOrderItemList(cart, order);
        orderItemRepository.saveAll(orderItems);
        cart.clearCart();
    }


}
