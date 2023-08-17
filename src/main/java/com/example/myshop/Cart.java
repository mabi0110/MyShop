package com.example.myshop;

import com.example.myshop.model.Item;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.thymeleaf.templateparser.ITemplateParser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
public class Cart {

    private List<CartItem> cartItems = new ArrayList<>();
    private int counter = 0;
    private BigDecimal sum = BigDecimal.ZERO;

    public void addItem(Item item) {
        boolean notFound = true;

        for (CartItem cartItem : cartItems) {
            if (cartItem.getItem().getId().equals(item.getId())) {
                notFound = false;
                cartItem.increaseCounter();
                recalculatePriceAndCounter();
                break;
            }
        }

        if (notFound) {
            cartItems.add(new CartItem(item));
            recalculatePriceAndCounter();
        }
    }

    public void removeItem(Item item) {
        for (CartItem cartItem : cartItems) {
            if (cartItem.getItem().getId().equals(item.getId())) {
                cartItem.decreaseCounter();
                if (cartItem.hasZeroItems()) {
                    cartItems.remove(cartItem);
                }
                recalculatePriceAndCounter();
                break;
            }
        }
    }

    private void recalculatePriceAndCounter() {
        int tempCounter = 0;
        BigDecimal temPrice = BigDecimal.ZERO;

        for (CartItem cartItem : cartItems) {
            tempCounter += cartItem.getCounter();
            temPrice = temPrice.add(cartItem.getPrice());
        }

        this.counter = tempCounter;
        this.sum = temPrice;

    }
}
