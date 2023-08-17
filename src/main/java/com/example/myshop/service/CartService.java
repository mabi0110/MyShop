package com.example.myshop.service;

import com.example.myshop.Cart;
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

    public void addItemToCart(Long itemId){

        Optional<Item> optionalItem = itemRepository.findById(itemId);
        if (optionalItem.isPresent()){
            Item item = optionalItem.get();
            cart.addItem(item);
        }
    }

    public void decreaseItem(Long itemId) {
        Optional<Item> optionalItem = itemRepository.findById(itemId);
        if (optionalItem.isPresent()){
            Item item = optionalItem.get();
            cart.decreaseItem(item);
        }
    }

    public void removeItem(Long itemId) {
        Optional<Item> optionalItem = itemRepository.findById(itemId);
        if (optionalItem.isPresent()){
            Item item = optionalItem.get();
            cart.removeAllItems(item);
        }
    }
}
