package com.example.customer.component.behaviour;
//Du brauchst einen Service, der die Logik für den Zugriff auf die Daten durchführt.
//Dieser Service ruft das Repository im connector-Ordner auf.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer.component.structure.Customer;
import com.example.customer.connector.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Methode zum Speichern eines Kunden
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Methode zum Abrufen eines Kunden nach ID
    public Optional<Customer> getCustomerById(Integer id) {
        return customerRepository.findById(id);
    }

    // Methode zum Abrufen aller Kunden
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Methode zum Löschen eines Kunden
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
}

