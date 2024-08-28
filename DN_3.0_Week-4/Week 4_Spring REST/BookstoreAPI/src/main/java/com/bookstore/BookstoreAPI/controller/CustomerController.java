package com.bookstore.BookstoreAPI.controller;

import com.bookstore.BookstoreAPI.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>(); // Temporary list to simulate a database

    // POST: Create a new customer using JSON request body
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        // Generate a new ID (In a real application, this would be handled by the database)
        long newId = customers.size() + 1;
        customer.setId(newId);
        customers.add(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }
    
    // Optional: GET all customers (for testing purposes)
    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers() {
        return ResponseEntity.ok(customers);
    }
    

	 // POST: Create a new customer using form data
	 @PostMapping("/form")
	 public ResponseEntity<Customer> createCustomerFromForm(
	         @RequestParam String name,
	         @RequestParam String email,
	         @RequestParam String password) {
	
	     // Create a new Customer object with the form data
	     Customer customer = new Customer();
	     customer.setId((long) (customers.size() + 1)); // Generate a new ID
	     customer.setName(name);
	     customer.setEmail(email);
	     customer.setPassword(password);
	
	     // Add the customer to the list
	     customers.add(customer);
	     
	     // Return the created customer with a status of CREATED
	     return ResponseEntity.status(HttpStatus.CREATED).body(customer);
	 }
}
