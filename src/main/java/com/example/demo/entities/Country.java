package com.example.demo.entities;

import java.util.Date;
import java.util.Set;

public class Country {

    private Long id;

    private String countryName;

    private Date createDate;

    private Date lastUpdate;

    private Set<Division> divisions;

    public Country() {

    }
}
