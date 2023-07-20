package com.example.demo.services;

import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Set;
import java.util.UUID;


@Service
@Validated
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;

    private CartRepository cartRepository;

    public CheckoutServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse checkout(Purchase purchase) {

//        if (!purchase.isValid()) {
//            throw new IllegalArgumentException("Invalid purchase data");
//        }
        Cart cart = purchase.getCart();
        cart.setStatus(StatusType.ordered);
        String orderTrackingNumber = generateOrderTrackingNumber();

        cart.setOrderTrackingNumber(orderTrackingNumber);

        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(cartItem -> cart.add(cartItem));

        cartRepository.save(cart);

        //Customer customer = purchaseData.getCustomerCart().getCustomer();
        //customer.add(cart);

        //customerRepository.save(customer);
        // save cartRepository

        return new PurchaseResponse(orderTrackingNumber);
    }


    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
