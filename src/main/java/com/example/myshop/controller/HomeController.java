package com.example.myshop.controller;

import com.example.myshop.model.Item;
import com.example.myshop.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    private final CartService cartService;

    public HomeController(CartService cartService) {
        this.cartService = cartService;
    }


    @GetMapping("/")
    public String home(Model model) {
        List<Item> items = cartService.getAllItems();
        model.addAttribute("items", items);
        return "home";
    }

    @GetMapping("/add/{itemId}")
    public String addItemToCart(@PathVariable Long itemId, Model model) {
        cartService.addItemToCart(itemId);
        List<Item> items = cartService.getAllItems();
        model.addAttribute("items", items);
        return "home";
    }
}
