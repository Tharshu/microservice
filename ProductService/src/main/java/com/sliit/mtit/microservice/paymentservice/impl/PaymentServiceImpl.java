package com.sliit.mtit.microservice.paymentservice.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.sliit.mtit.microservice.paymentservice.dto.PaymentCreationRequest;
import com.sliit.mtit.microservice.paymentservice.dto.PaymentCreationResponse;
import com.sliit.mtit.microservice.paymentservice.dto.paymentRequest;
import com.sliit.mtit.microservice.paymentservice.dto.paymentResponse;

@SpringBootApplication
public class PaymentServiceImpl {


    @Autowired
    private RestTemplate restTemplate;

    public paymentResponse makepayment(paymentRequest paymentRequest){

        PaymentCreationRequest paymentCreationRequest = new PaymentCreationRequest();
        paymentCreationRequest.setAge(paymentRequest.getAge());
        paymentCreationRequest.setFullname(paymentRequest.getFullname());
        ResponseEntity<PaymentCreationResponse> userCreationResponse = restTemplate.postForEntity("http://localhost:5223/users",paymentCreationRequest, PaymentCreationResponse.class);

        paymentResponse paymentResponse = new paymentResponse();
        paymentResponse.setpaymentId(UUID.randomUUID().toString());
        paymentResponse.setUserId(userCreationResponse.getBody().getUserId());
        paymentResponse.setMessage("Successfully payment made");

        return paymentResponse;
    }
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

}
