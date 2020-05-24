package com.myapp.controllers;

import com.myapp.exceptions.NotFoundItemException;
import com.myapp.entities.Order;
import com.myapp.entities.Item;
import com.myapp.repos.ItemRepos;
import com.myapp.repos.OrderRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("main")
public class CustomerRestController {      // класс пользователя. позволяет добавлять, удалять товары в корзину(заказ)
    private ArrayList<Item> lst = new ArrayList<Item>();
    @Autowired
    private ItemRepos repos;
    @Autowired
    private OrderRepos orderRepos;


    @PutMapping
    // Добавление товара в корзину
    public ArrayList<Item> addToOrder(@RequestParam String name, @RequestParam Float price) throws NotFoundItemException {
        Item newItem = repos.findByNameAndPrice(name, price);
        if (newItem == null) throw new NotFoundItemException(name);
        lst.add(repos.findByNameAndPrice(name, price));
        return lst;
    }

    @DeleteMapping
    // Удаление товара из корзины
    public void deleteFromOrder(@RequestParam String name, @RequestParam Float price) throws NotFoundItemException {
        int i = 0;
        for (Item item : lst) {    // поиск в списке по имени и цене
            if (item.getName().equals(name) && item.getPrice().equals(price)) {
                lst.remove(i);
                return;
            }
        }
        throw new NotFoundItemException(name); // исключение, если товар не найден
    }
    @Transactional
    @GetMapping("/submit")
    // Подверждение заказа. Заказ сохраняется в бд
    public void submitOrder() {
        Order order = new Order();
        String orderList = "";
        for (Item item : lst) {
            orderList = orderList.concat(item.toString());
            order.addTotal(item.getPrice());
        }
        order.setStringItemList(orderList);
        orderRepos.save(order);
    }
    @GetMapping("/show")
    // Отображение заказа
    public String showCart() {
        String orderList = "";
        float total = 0;
        for (Item item : lst) {
            orderList = orderList.concat(item.toString());
            total += item.getPrice();
        }
        return orderList + " Total: " + total ;
    }
}