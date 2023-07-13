package com.example.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


@Service
@Validated
public class CheckoutServiceImpl implements CheckoutService{

    @Override
    public PurchaseResponseData checkout(PurchaseData purchaseData) {

        if (!purchaseData.isValid()) {
            throw new IllegalArgumentException("Invalid purchase data");
        }

        String orderTrackingNumber = generateOrderTrackingNumber();
        PurchaseResponseData purchaseResponseData = new PurchaseResponseData();
        purchaseResponseData.setOrderTrackingNumber(orderTrackingNumber);

        return purchaseResponseData;
    }


    private String generateOrderTrackingNumber() {
        return "ORD123456789";
    }
}
