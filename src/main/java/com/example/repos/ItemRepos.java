package com.example.repos;

import com.example.entities.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepos extends CrudRepository<Item, Integer> {
    List<Item> findByName(String name);
    Item findById(Long id);

    @Query("SELECT item FROM Item item WHERE item.name LIKE CONCAT('%',:subStr,'%')")
    List<Item> findByPartOfName(String subStr);
}
