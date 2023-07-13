package com.example.demo.services;

import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNullFields;
import org.springframework.validation.annotation.Validated;


import java.util.Set;
@Data
@NoArgsConstructor
@Getter
@Setter
@Validated
public class PurchaseData {


    private Cart customerCart;
    private Set<CartItem> cartItems;

    public boolean isValid() {
        return customerCart != null && cartItems!= null && !cartItems.isEmpty();
    }
}
