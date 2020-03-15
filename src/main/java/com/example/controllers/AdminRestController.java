package com.example.controllers;

import com.example.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminRestController {        // класс, позволяющий создавать, удалять и изменять товары
    private List<Product> lst = new ArrayList<Product>();
    private int counter = 3;

    public AdminRestController() {
        lst.add(new Product(1, "hello", (float)151));
        lst.add(new Product(2, "dfmbklkf", (float)1546));
        lst.add(new Product(3, "hbjhbj", (float)18789));
    }

    @GetMapping
    public List<Product> showProdList() {
        return lst;
    }

    @GetMapping("{name}")       // показывает список доступных товаров
    public Product getOne(@PathVariable String name) {
        int i = 0;
        while (!lst.get(i).getName().equals(name)) {
            if (i < lst.size() - 1) i++;
            else break;
        }
        return lst.get(i);
    }

    @PostMapping            // добавление нового товара
    public Product create(@RequestBody Product product) {
        counter++;
        lst.add(product);
        return product;
    }

    @PutMapping("{name}")       // изменение существующего товара
    public Product update(@PathVariable String name, @RequestBody Product product) {
        int i = 0;
        while(!lst.get(i).getName().equals(name)){
            if (i < lst.size() - 1) i++;
            else break;
        }
        lst.set(i, product);
        return product;
    }
    @DeleteMapping("{name}")        // удаление товара
    public void delete(@PathVariable String name) {
        int i = 0;
        while(!lst.get(i).getName().equals(name)) {
            if (i < lst.size() - 1) i++;
            else break;
        }
        lst.remove(i);
    }
}
