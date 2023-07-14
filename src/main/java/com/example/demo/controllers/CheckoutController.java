package com.example.demo.controllers;

import com.example.demo.services.CheckoutService;
import com.example.demo.services.PurchaseData;
import com.example.demo.services.PurchaseResponseData;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Data

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    public ResponseEntity<PurchaseResponseData> placeOrder(@RequestBody PurchaseData purchaseData) {
        PurchaseResponseData purchaseResponseData = checkoutService.checkout(purchaseData);
        return ResponseEntity.ok(purchaseResponseData);
    }
}


