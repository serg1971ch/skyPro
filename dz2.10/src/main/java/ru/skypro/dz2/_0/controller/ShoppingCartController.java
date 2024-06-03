package ru.skypro.dz2._0.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.dz2._0.model.Item;
import ru.skypro.dz2._0.service.ShoppingCartService;

import java.util.List;

@RestController
@RequestMapping("/order")
public class ShoppingCartController {
    private final ShoppingCartService service;

    public ShoppingCartController(ShoppingCartService service) {
        this.service = service;
    }

    @GetMapping(value = "/add")
    public void add(@RequestParam("id") List<Integer> idItems) {
        service.add(idItems);
    }

    @GetMapping(value = "/get")
    public List<Item> get() {
        return service.get();
    }
}
