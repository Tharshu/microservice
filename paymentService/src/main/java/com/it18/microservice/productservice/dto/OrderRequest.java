package com.it18.microservice.productservice.dto;

import java.util.StringJoiner;

public class OrderRequest {

    private String fullname;
    private String age;
    private String orderType;
    private String orderDetails;

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

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OrderRequest.class.getSimpleName() + "[", "]")
                .add("fullname='" + fullname + "'")
                .add("age='" + age + "'")
                .add("orderType='" + orderType + "'")
                .add("orderDetails='" + orderDetails + "'")
                .toString();
    }
}
