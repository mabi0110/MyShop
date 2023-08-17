package com.example.myshop.controller;

import com.example.myshop.model.Item;
import com.example.myshop.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final CartService cartService;

    public OrderController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart")
    public String showCart() {
        return "cartView";
    }

    @GetMapping("/increase/{itemId}")
    public String increaseItem(@PathVariable Long itemId) {
        cartService.addItemToCart(itemId);
        return "cartView";
    }

    @GetMapping("/decrease/{itemId}")
    public String decreaseItem(@PathVariable Long itemId) {
        cartService.decreaseItem(itemId);
        return "cartView";
    }

    @GetMapping("/remove/{itemId}")
    public String removeItemsFromCart(@PathVariable Long itemId) {
        cartService.removeItem(itemId);
        return "cartView";
    }
}
