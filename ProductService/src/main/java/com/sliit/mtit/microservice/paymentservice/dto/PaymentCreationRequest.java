package com.sliit.mtit.microservice.paymentservice.dto;

public class PaymentCreationRequest {

    private String fullname;
    private String age;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
