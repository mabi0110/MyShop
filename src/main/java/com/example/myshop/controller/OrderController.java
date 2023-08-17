package com.example.myshop.controller;

import com.example.myshop.ItemOperation;
import com.example.myshop.dto.OrderDto;
import com.example.myshop.service.CartService;
import com.example.myshop.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final CartService cartService;

    private final OrderService orderService;

    public OrderController(CartService cartService, OrderService orderService) {
        this.cartService = cartService;
        this.orderService = orderService;
    }

    @GetMapping("/cart")
    public String showCart() {
        return "cartView";
    }

    @GetMapping("/increase/{itemId}")
    public String increaseItem(@PathVariable Long itemId) {
        cartService.itemOperation(itemId, ItemOperation.INCREASE);
        return "cartView";
    }

    @GetMapping("/decrease/{itemId}")
    public String decreaseItem(@PathVariable Long itemId) {
        cartService.itemOperation(itemId, ItemOperation.DECREASE);
        return "cartView";
    }

    @GetMapping("/remove/{itemId}")
    public String removeItemsFromCart(@PathVariable Long itemId) {
        cartService.itemOperation(itemId, ItemOperation.REMOVE);
        return "cartView";
    }

    @GetMapping("/summary")
    public String showSummary() {
        return "summary";
    }

    @PostMapping("/saveorder")
    public String saveOrder(OrderDto orderDto){
        orderService.saveOrder(orderDto);

        return "redirect:/";
    }
}
