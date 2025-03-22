package com.example.customer.component.behaviour;

import com.example.customer.connector.CustomerSpringDataJPAConnector;
import com.example.customer.connector.ForeignOrderRestConnectorRequester;
import com.example.customer.dto.OrderDTO;
import com.example.customer.component.structure.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerSpringDataJPAConnector customerRepository;
    private final ForeignOrderRestConnectorRequester orderConnector;

    public CustomerService(CustomerSpringDataJPAConnector customerRepository, 
                           ForeignOrderRestConnectorRequester orderConnector) {
        this.customerRepository = customerRepository;
        this.orderConnector = orderConnector;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Integer id) {
        return customerRepository.findById(id);
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    public List<OrderDTO> getOrdersForCustomer(Integer customerId) {
        return orderConnector.getOrdersByCustomerId(customerId);
    }

}

