package com.myapp.controllers;

import com.myapp.exceptions.NotFoundItemException;
import com.myapp.entities.Item;
import com.myapp.repos.ItemRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.Cacheable;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminRestController {        // класс, позволяющий создавать, удалять и изменять товары
    @Autowired
    private ItemRepos repos;

    @Transactional // подключение аннотации для транзакции
    @GetMapping
    @Cacheable("findByName")    // кэширование
    // Поиск в бд по имени
    public List<Item> findByName(@RequestParam String name) throws NotFoundItemException {
        List<Item> lst = repos.findByPartOfName(name);
        if(lst.isEmpty()) throw new NotFoundItemException(name);
        return lst;
    }
    @Transactional
    @PostMapping
    // Добавление в бд нового товара. Новый товар создается по имени и его стоимости, id генерируется самостоятельно
    public Item create(@RequestParam String name, @RequestParam Float price) {
        Item addedItem = new Item(name, price);
        repos.save(addedItem);
        return addedItem;
    }
    @Transactional
    @PutMapping
    // Изменение существующего товара в базе данных на новый
    public Item update(@RequestParam String name, @RequestParam Float price, @RequestBody Item newItem) throws NotFoundItemException {
        Item oldItem = repos.findByNameAndPrice(name, price);   // поиск старого товара
        if (oldItem == null) throw new NotFoundItemException(name); // выход, если товар не найден
        oldItem.setName(newItem.getName());     // установка нового имени и цены
        oldItem.setPrice(newItem.getPrice());
        repos.save(oldItem);    // сохранение в бд
        return newItem;
    }
    @Transactional
    @DeleteMapping("/id")      // удаление товара
    public void removeItemById(@RequestParam Integer id) {
        repos.deleteById(id);   // удаление по id
    }

    @Transactional
    @DeleteMapping("/name")      // удаление товара
    public void removeItemByNameAndPrice(@RequestParam String name, @RequestParam Float price) {
        repos.deleteByNameAndPrice(name, price); // удаление по названию и цене
    }

}