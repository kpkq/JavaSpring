package com.example.test;

import com.example.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("admin")
public class ProductRestController {
    private List<Product> lst = new ArrayList<Product>();
    private int counter = 3;

    public ProductRestController() {
        lst.add(new Product(1, "hello", (float)151));
        lst.add(new Product(2, "dfmbklkf", (float)1546));
        lst.add(new Product(3, "hbjhbj", (float)18789));
    }

    @GetMapping
    public List<Product> showProdList() {
        return lst;
    }

    @GetMapping("{name}")
    public Product getOne(@PathVariable String name) {
        int i = 0;
        while (!lst.get(i).getName().equals(name)) {
            if (i < lst.size() - 1) i++;
            else break;
        }
        return lst.get(i);
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        counter++;
        lst.add(product);
        return product;
    }

    @PutMapping("{name}")
    public Product update(@PathVariable String name, @RequestBody Product product) {
        int i = 0;
        while(!lst.get(i).getName().equals(name)){
            if (i < lst.size() - 1) i++;
            else break;
        }
        lst.set(i, product);
        return product;
    }
    @DeleteMapping("{name}")
    public void delete(@PathVariable String name) {
        int i = 0;
        while(!lst.get(i).getName().equals(name)) {
            if (i < lst.size() - 1) i++;
            else break;
        }
        lst.remove(i);
    }
}
