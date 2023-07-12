package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;
@Entity
@Table(name = "CART_ITEMS")
@Data
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cart_Item_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Vacation_ID")
    private Vacation vacation;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "excursion_cartitem",
            joinColumns = @JoinColumn(name = "Excursion_ID"),
            inverseJoinColumns = @JoinColumn(name = "Cart_Item")
    )
    private Set<Excursion> excursions;

    @ManyToOne
    @JoinColumn(name = "Cart_ID", nullable = false)
    private Cart cart;

    @Column(name = "Create_Date")
    @CreationTimestamp
    private Date createDate;

    @Column(name = "Last_Update")
    @UpdateTimestamp
    private Date lastUpdate;

    public CartItem() {

    }
}
