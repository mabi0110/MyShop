package com.example.myshop.controller;

import com.example.myshop.model.Item;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/pencil")
    @ResponseBody
    public Item pencil() {
        return new Item(
                "Ołówek",
                new BigDecimal("1.5"),
                "https://iheartcraftythings.com/wp-content/uploads/2021/05/Pencil-DRAWING-%E2%80%93-STEP-10.jpg"
        );
    }

    @GetMapping("/addItem")
    public String addItem() {
        return "addItem";
    }

    @GetMapping("/summary")
    public String summary() {
        return "summary";
    }

    @GetMapping("/cartView")
    public String cartView() {
        return "cartView";
    }

}
