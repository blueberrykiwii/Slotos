package com.example.shop.connector;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.order.component.structure.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, Integer> {
    // Hier kannst du zusätzliche Abfragen definieren, falls nötig
}
