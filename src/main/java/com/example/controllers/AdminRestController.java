package com.example.controllers;

import com.example.model.Product;
import org.springframework.web.bind.annotation.*;
import com.example.exceptions.notFoundProductException;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminRestController {        // класс, позволяющий создавать, удалять и изменять товары
    private List<Product> lst = new ArrayList<Product>();

    public AdminRestController() {
        lst.add(new Product(1, "item1", 151));
        lst.add(new Product(2, "item2", 1546));
        lst.add(new Product(3, "ite3", 8789));
    }

    @GetMapping
    public List<Product> showProdList() {
        return lst;
    }

    @GetMapping("{name}")       // показывает список доступных товаров
    public Product getOne(@PathVariable String name) throws notFoundProductException {
        return lst.get(findInList.findPozByName(lst, name));
    }

    @PostMapping            // добавление нового товара
    public Product create(@RequestBody Product product) {
        lst.add(product);
        return product;
    }

    @PutMapping("{name}")       // изменение существующего товара
    public Product update(@PathVariable String name, @RequestBody Product product) throws notFoundProductException {
        lst.set(findInList.findPozByName(lst, name), product);
        return product;
    }
    @DeleteMapping("{name}")        // удаление товара
    public void delete(@PathVariable String name) throws notFoundProductException {
        lst.remove(findInList.findPozByName(lst, name));
    }
}
