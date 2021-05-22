package com.it18.microservice.orderservice.dto;

public class UserCreationResponse {

    private String productId;
    private String message;

    public String getproductId() {
        return productId;
    }

    public void setproductId(String productId) {
        this.productId = productId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
