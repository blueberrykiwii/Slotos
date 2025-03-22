package com.example.order.connector;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.order.component.structure.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

	Optional<Order> findById(String id);
    // Hier kannst du zusätzliche Abfragen definieren, falls nötig

	void deleteById(String id);
}
