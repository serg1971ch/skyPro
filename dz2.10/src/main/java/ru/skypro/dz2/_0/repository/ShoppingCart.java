package ru.skypro.dz2._0.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.skypro.dz2._0.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

@Component
public class ShoppingCart {
    private final Map<Integer, Item> items = new HashMap<>();

    @PostConstruct
    public void init(){
        int idCount = 1;
        items.put(idCount, new Item(idCount++) );
        items.put(idCount, new Item(idCount++) );
        items.put(idCount, new Item(idCount++) );
    }

    public Item get(int id) {
        return items.get(id);
    }

}
