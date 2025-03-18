package com.example.customer.connector;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.customer.component.structure.Cart;

@Repository
public interface CartItemRepository extends JpaRepository<Cart, Integer> {
}
