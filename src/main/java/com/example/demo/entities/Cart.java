package com.example.demo.entities;

import jakarta.transaction.Status;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class Cart {

    private Long id;

    private String orderTrackingNumber;

    private BigDecimal packagePrice;

    private int partySize;

    private StatusType status;

    private Date createDate;

    private Date lastUpdate;

    private Customer customer;

    private Set<CartItem> cartItem;

    public Cart() {

    }
}
