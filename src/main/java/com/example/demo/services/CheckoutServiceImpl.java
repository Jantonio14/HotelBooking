package com.example.demo.services;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Set;
import java.util.UUID;


@Service
@Validated
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponseData checkout(PurchaseData purchaseData) {

        if (!purchaseData.isValid()) {
            throw new IllegalArgumentException("Invalid purchase data");
        }
        Cart cart = purchaseData.getCustomerCart();
        String orderTrackingNumber = generateOrderTrackingNumber();

        cart.setOrderTrackingNumber(orderTrackingNumber);

        Set<CartItem> cartItems = purchaseData.getCartItems();
        cartItems.forEach(cartItem -> cart.add(cartItem));

        Customer customer = purchaseData.getCustomerCart().getCustomer();
        customer.add(cart);

        customerRepository.save(customer);

        return new PurchaseResponseData(orderTrackingNumber);
    }


    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
