package com.sliit.mtit.microservice.paymentservice.dto;


import java.util.StringJoiner;

public class UserRequest {

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

    @Override
    public String toString() {
        return new StringJoiner(", ", UserRequest.class.getSimpleName() + "[", "]")
                .add("fullname='" + fullname + "'")
                .add("age='" + age + "'")
                .toString();
    }
}
