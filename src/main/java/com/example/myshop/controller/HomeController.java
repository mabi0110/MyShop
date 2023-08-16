package com.example.myshop.controller;

import com.example.myshop.model.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    static List<Item> items = new ArrayList<>();

    static {
        items.add(new Item("Długopis", new BigDecimal("3.8"), "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTqagQWzJRwvotqcrZD5TZhk5eqE1QvPJ7dAYHiLXhrcWyeHiq-YA46S57PVnf5wR_-Bmg&usqp=CAU"));
        items.add(new Item("Pióro", new BigDecimal("12.6"), "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSAatvszFV6LIDGoo_JIVXZRONRpzYDExm3uw&usqp=CAU"));
        items.add(new Item("Ołówek", new BigDecimal("1.5"), "https://iheartcraftythings.com/wp-content/uploads/2021/05/Pencil-DRAWING-%E2%80%93-STEP-10.jpg"));
    }


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("items", items);
        return "home";
    }


}
