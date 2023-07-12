package com.example.demo.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class Vacation {

    private Long id;

    private String vacationTitle;

    private String description;

    private BigDecimal travelPrice;

    private String imageUrl;

    private Date createDate;

    private Date lastUpdate;

    private Set<Excursion> excursions;

    public Vacation() {

    }
}
