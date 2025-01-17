package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vacations")

@Getter
@Setter
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    private Long id;

    @Column(name = "vacation_title")
    private String vacation_title;

    @Column(name = "description")
    private String description;

    @Column(name = "travel_fare_price")
    private BigDecimal travel_price;

    @Column(name = "image_url")
    private String image_URL;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    public Vacation() {

    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "vacation_id")
    Set<Excursion> excursions;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "vacation_id")
    Set<CartItem> cartItems = new HashSet<>();
//    public void add(Excursion excursion) {
//
//        if (excursion != null) {
//            if (excursions == null) {
//                excursions = new HashSet<>();
//            }
//
//            excursions.add(excursion);
//            excursion.setVacation(this);
//        }
//    }
}
