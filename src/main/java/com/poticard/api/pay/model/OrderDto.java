package com.poticard.api.pay.model;

public class OrderDto {
    private String paymentId;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public OrderDto() {
    }

    public OrderDto(String paymentId) {
        this.paymentId = paymentId;
    }
}
