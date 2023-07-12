package com.example.demo.entities;

import java.util.Date;
import java.util.Set;

public class Customer {

    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private String postalCode;

    private String phone;

    private Date createData;

    private Date lastUpdate;

    private Long division;

    private Set<Cart> carts;

    public Customer() {

    }


}
