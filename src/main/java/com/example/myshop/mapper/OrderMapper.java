package com.example.myshop.mapper;

import com.example.myshop.Cart;
import com.example.myshop.CartItem;
import com.example.myshop.dto.OrderDto;
import com.example.myshop.model.order.Order;
import com.example.myshop.model.order.OrderItem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    public static Order mapToOrder(OrderDto orderDto){
        return Order.builder()
                .firstName(orderDto.getFirstName())
                .lastName(orderDto.getLastName())
                .address(orderDto.getAddress())
                .postCode(orderDto.getPostCode())
                .city(orderDto.getCity())
                .created(LocalDateTime.now())
                .build();
    }

    public static List<OrderItem> mapToOrderItemList(Cart cart, Order order) {
        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItem cartItem : cart.getCartItems()) {
            orderItems.add(new OrderItem(order.getOrderId(), cartItem.getItem().getId(), cartItem.getCounter()));
        }
        return orderItems;
    }
}
