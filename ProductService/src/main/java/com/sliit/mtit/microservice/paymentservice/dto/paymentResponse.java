package com.sliit.mtit.microservice.paymentservice.dto;

public class paymentResponse {

    private String paymentId;
    private String userId;
    private String message;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getpaymentId() {
        return paymentId;
    }

    public void setpaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


	
}
