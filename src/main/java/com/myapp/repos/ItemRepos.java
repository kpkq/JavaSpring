package com.myapp.repos;

import com.myapp.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface ItemRepos extends JpaRepository<Item, Integer> {
    Item findByNameAndPrice(String name, Float price);      // поиск по имени и цене
    @Query("SELECT item FROM Item item WHERE item.name LIKE CONCAT('%',:subStr,'%')") // запрос для поиска по подстроке в бд
    List<Item> findByPartOfName(String subStr);
    void deleteById(Integer id);    // удаление по id
    void deleteByNameAndPrice(String name, Float price);     // удаление по имени и цене
}
