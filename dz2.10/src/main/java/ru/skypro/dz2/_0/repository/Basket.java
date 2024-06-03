package ru.skypro.dz2._0.repository;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import ru.skypro.dz2._0.model.Item;

import java.util.ArrayList;
import java.util.*;


@Component
@SessionScope
public class Basket {
    private final List<Item> itemList = new ArrayList<>();

    public void add(List<Item> items) {
        this.itemList.addAll(items);
    }

    public List<Item> get() {
        return Collections.unmodifiableList(itemList);
    }
}
