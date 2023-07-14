package com.example.demo.services;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data

public class CustomerDataInitializer implements CommandLineRunner {

    private CustomerRepository customerRepository;



    @Override
    public void run(String... args) throws Exception {
        if (customerRepository.count() == 0) {
            createCustomers();
        }
    }

    private void createCustomers() {
        Customer firstCustomer = new Customer(2L, "John", "Doe",
                "123 Main St", "12345", "555-1234", new Date(), new Date(), 20L);

        Customer secondCustomer = new Customer(3L, "Jacil", "Perez",
                "231 Broad St", "10468", "555-4321", new Date(), new Date(), 30L);

        Customer thirdCustomer = new Customer(4L, "Jane", "Perez",
                "103 Clarke St", "11568", "555-4561", new Date(), new Date(), 40L);

        Customer fourthCustomer = new Customer(5L, "Tony", "Garcia",
                "50 Plain St", "13546", "555-8765", new Date(), new Date(), 50L);

        Customer fifthCustomer = new Customer(6L, "Elliot", "Smith",
                "12 W Main", "14567", "555-3346", new Date(), new Date(), 60L);
    }
}
