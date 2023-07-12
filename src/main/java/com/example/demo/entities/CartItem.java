package com.example.demo.entities;

import java.util.Date;
import java.util.Set;

public class CartItem {

    private Long id;

    private Vacation vacation;

    private Set<Excursion> excursions;

    private Cart cart;

    private Date createDate;

    private Date lastUpdate;

    public CartItem() {

    }
}
