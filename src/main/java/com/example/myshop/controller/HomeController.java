package com.example.myshop.controller;

import com.example.myshop.model.Item;
import com.example.myshop.repository.ItemRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    private final ItemRepository itemRepository;

    public HomeController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "home";
    }

    @GetMapping("/add/{itemId}")
    public String addItemToCart(@PathVariable Long itemId, Model model, HttpSession session) {
        @SuppressWarnings("uncheked")
        List<Item> cart = (List<Item>)session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        Optional<Item> optionalItem = itemRepository.findById(itemId);
        if (optionalItem.isPresent()){
            Item item = optionalItem.get();
            cart.add(item);
            session.setAttribute("cart", cart);
        }
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "home";
    }
}
