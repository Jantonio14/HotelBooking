package com.example.demo.entities;

import java.util.Date;
import java.util.Set;

public class Division {

    private Long id;

    private String divisionName;

    private Date createDate;

    private Date lastUpdate;

    private Country country;

    private Long countryId;

    private Set<Customer> customers;

    public Division() {

    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
