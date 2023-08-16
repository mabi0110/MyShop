package com.example.myshop;

import com.example.myshop.model.Item;
import com.example.myshop.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class DbInit implements CommandLineRunner {

    private final ItemRepository itemRepository;

    public DbInit(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        itemRepository.saveAll(List.of(
                new Item("Długopis", new BigDecimal("3.8"), "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTqagQWzJRwvotqcrZD5TZhk5eqE1QvPJ7dAYHiLXhrcWyeHiq-YA46S57PVnf5wR_-Bmg&usqp=CAU"),
                new Item("Pióro", new BigDecimal("12.6"), "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSAatvszFV6LIDGoo_JIVXZRONRpzYDExm3uw&usqp=CAU"),
                new Item("Ołówek", new BigDecimal("1.5"), "https://iheartcraftythings.com/wp-content/uploads/2021/05/Pencil-DRAWING-%E2%80%93-STEP-10.jpg")
        ));
    }
}
