package com.example.controllers;

import java.util.List;
import java.util.Map;

import com.example.entities.Item;
import com.example.entities.Order;
import com.example.repos.ItemRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private ItemRepos repos;

    private Order order = new Order();

    private static Iterable<Item> lst;

    @GetMapping("/finditem")
    public String showFindItem(Map<String, Object> model) {
        //lst = repos.findAll();
        model.put("list", lst);
        model.put("order", order);
        return "findItem";
    }

    @PostMapping("/finditem")
    public String findItem(@RequestParam(name = "name1") String name, Map<String, Object> model) {
        lst = repos.findByPartOfName(name);
        model.put("list", lst);
        return "redirect:/finditem";
    }

    @GetMapping("/addtocartitem/{id}")
    public String addToCartItem(@PathVariable Integer id) {
        //order.addItemToList(new Item(repos.findById(id).get()));
        order.addTotal(repos.findById(id).get().getPrice());
        return "redirect:/finditem";
    }

    @GetMapping("/additem")
    public String saveAddItem() {
        return "addItem";
    }

    @PostMapping("/additem")
    public String addItem(@RequestParam(name = "name") String name, @RequestParam(name = "price") Float price,
                          Map<String, Object> model) {
        Item item = new Item(name, price);
        repos.save(item);
        model.put("newObj", item);
        return "addItem";
    }


}