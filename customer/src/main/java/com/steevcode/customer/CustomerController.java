package com.steevcode.customer;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
public class CustomerController {

   private final CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Customer>> getCustomer(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerService.getCustomer(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getCustomers(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerService.getAllCustomer());
    }

    @PostMapping
    public void createCustomer(@RequestBody CustomerRequestDTO customerRequest){
       customerService.registerCustomer(customerRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomers(@PathVariable Integer id, @RequestBody CustomerRequestDTO customerRequest){
        return customerService.updateCustomer(id, customerRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Customer deleted successfully");
    }
}
