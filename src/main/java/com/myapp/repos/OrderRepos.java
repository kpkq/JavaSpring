package com.myapp.repos;


import com.myapp.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepos extends JpaRepository<Order, Integer> {
}
