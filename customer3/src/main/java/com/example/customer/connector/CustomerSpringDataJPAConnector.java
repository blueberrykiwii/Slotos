package com.example.customer.connector;

import com.example.customer.component.structure.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerSpringDataJPAConnector extends JpaRepository<Customer, Integer> {
    // Falls spezielle Suchmethoden benötigt werden, hier hinzufügen
}
