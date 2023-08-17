package com.example.myshop.service;

import com.example.myshop.Cart;
import com.example.myshop.ItemOperation;
import com.example.myshop.model.Item;
import com.example.myshop.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private final ItemRepository itemRepository;
    private final Cart cart;

    public CartService(ItemRepository itemRepository, Cart cart) {
        this.itemRepository = itemRepository;
        this.cart = cart;
    }

    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    public void itemOperation(Long itemId, ItemOperation itemOperation){
        Optional<Item> optionalItem = itemRepository.findById(itemId);
        if (optionalItem.isPresent()){
            Item item = optionalItem.get();
            switch (itemOperation){
                case INCREASE -> cart.addItem(item);
                case DECREASE -> cart.decreaseItem(item);
                case REMOVE -> cart.removeAllItems(item);
                default -> throw new IllegalArgumentException();
            }
        }
    }
}
