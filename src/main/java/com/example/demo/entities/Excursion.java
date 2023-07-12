package com.example.demo.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class Excursion {

    private Long id;

    private String excursionTitle;

    private BigDecimal excursionPrice;

    private String imageUrl;

    private Date createDate;

    private Date lastUpdate;

    private Vacation vacation;

    private Set<CartItem> cartItems;

    public Excursion() {

    }
}
