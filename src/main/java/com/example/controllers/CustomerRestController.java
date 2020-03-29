package com.example.controllers;

import com.example.exceptions.notFoundProductException;
import com.example.model.Order;
import com.example.model.Product;
import org.springframework.web.bind.annotation.*;
import com.example.controllers.AdminRestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("main")
public class CustomerRestController {      // класс пользователя. позволяет добавлять, удалять товары в корзину(заказ)
    private Order order = new Order();
    private static List<Product> lst = new ArrayList<Product>();

    public CustomerRestController() {       // изначальный список товаров для покупки
        lst.add(new Product(1, "item1", 151.0));
        lst.add(new Product(2, "item2", 1546));
        lst.add(new Product(3, "item3", 189));
    }
    @GetMapping()
    public List<Product> showList() {return  lst;}

    @GetMapping("/showorder")
    public Order showOrder() {
        return order;
    }

    @PutMapping("{name}")       // добавить товар в корзину
    public void addToOrder(@PathVariable String name) throws notFoundProductException {
        order.addToOrder(new Product(lst.get(findInList.findPozByName(lst, name))));
    }
    @DeleteMapping("{name}")           // удалить товар из корзины
    public void deleteFromOrder(@PathVariable String name) throws notFoundProductException {
        order.deleteFromOrder(findInList.findPozByName(order.getItemList(), name));
    }

}
