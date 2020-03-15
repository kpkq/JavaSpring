package com.example.test;

import com.example.model.Order;
import com.example.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("main")
public class CustomerRestController {
    private Order order = new Order();
    private static List<Product> lst = new ArrayList<Product>();

    public CustomerRestController() {
        lst.add(new Product(1, "hello", 151.0));
        lst.add(new Product(2, "dfmbklkf", 1546));
        lst.add(new Product(3, "hbjhbj", 18789));
    }

    @GetMapping
    public Order showOrder() {
        return order;
    }

    @PutMapping("{name}")
    public void addToOrder(@PathVariable String name) {
        int i = 0;
        while (!lst.get(i).getName().equals(name)) {
            if (i < order.size() - 1) i++;
            else break;
        }
        order.addToOrder(new Product(lst.get(i)));
    }
    @DeleteMapping("{name}")
    public void deleteFromOrder(@PathVariable String name) {
        int i = 0;
        while (!order.getItemList().get(i).getName().equals(name)) {
            if (i < order.size() - 1) i++;
            else break;
        }
        order.deleteFromOrder(i);
    }

}
