package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "VACATIONS")
@Data
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Vacation_ID")
    private Long id;

    @Column(name = "Vacation_Title")
    private String vacationTitle;

    @Column(name = "Description")
    private String description;

    @Column(name = "Travel_Fare_Price")
    private BigDecimal travelPrice;

    @Column(name = "Image_URL")
    private String imageUrl;

    @CreationTimestamp
    @Column(name = "Create_Date")
    private Date createDate;

    @UpdateTimestamp
    @Column(name = "Last_Update")
    private Date lastUpdate;

    private Set<Excursion> excursions;

    public Vacation() {

    }
}
