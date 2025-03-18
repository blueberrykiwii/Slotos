// Passe das an, falls dein Package anders heiß

//CustomerSpringDataConnectorRequester wird als eine Klasse erstellt, die den Zugriff 
//auf alle Entitäten (Customer, Cart, CartItem) abwickelt.
//Repository für Customer, Cart und CartItem: In dieser Klasse wirst du dann die Spring Data JPA-Repositories für Customer, 
//Cart und CartItem importieren und deren Funktionalität zentral verwalten.

package com.example.customer.connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.customer.component.structure.Cart;
import com.example.customer.component.structure.CartItem;
import com.example.customer.component.structure.Customer;

import java.util.Optional;
import java.util.List;

@Component
public class CustomerSpringDataConnectorRequester {

    private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    @Autowired
    public CustomerSpringDataConnectorRequester(
            CustomerRepository customerRepository,
            CartRepository cartRepository,
            CartItemRepository cartItemRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    // Methoden für Customer
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> findCustomerById(Integer customerId) {
        return customerRepository.findById(customerId);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void deleteCustomer(Integer customerId) {
        customerRepository.deleteById(customerId);
    }

    // Methoden für Cart
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Optional<Cart> findCartById(Integer cartId) {
        return cartRepository.findById(cartId);
    }

    // Methoden für CartItem
    public CartItem saveCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public Optional<CartItem> findCartItemById(Integer cartItemId) {
        return cartItemRepository.findById(cartItemId);
    }
}
