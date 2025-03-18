package com.example.order.connector;


import com.example.order.component.structure.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderSpringDataMongoDBConnectorRequester extends MongoRepository<Order, String> {
    // Falls du spezielle Suchmethoden brauchst, kannst du sie hier hinzufügen
}
