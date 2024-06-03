package ru.skypro.dz2._0.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import ru.skypro.dz2._0.repository.Basket;
import ru.skypro.dz2._0.repository.ShoppingCart;
import ru.skypro.dz2._0.model.Item;

import java.util.*;

@Service
@SessionScope
public class ShoppingCartService {
    public final ShoppingCart cart;
    public final Basket bucket;

    public ShoppingCartService(ShoppingCart cart, Basket bucket) {
        this.cart = cart;
        this.bucket = bucket;
    }

    public void add(List<Integer> itemsId) {
        bucket.add(itemsId.stream()
                .map(cart::get)
                .toList());
    }

    public List<Item> get() {
        return bucket.get();
    }
}
