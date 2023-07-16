package com.example.demo.controllers;

import com.example.demo.services.CheckoutService;
import com.example.demo.services.PurchaseData;
import com.example.demo.services.PurchaseResponseData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")

    public ResponseEntity<PurchaseResponseData> placeOrder(@RequestBody PurchaseData purchaseData) {
        PurchaseResponseData purchaseResponseData = checkoutService.checkout(purchaseData);
        return ResponseEntity.ok(purchaseResponseData);
    }
}


