package com.it18.microservice.productservice.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.it18.microservice.productservice.dto.OrderRequest;
import com.it18.microservice.productservice.dto.OrderResponse;
import com.it18.microservice.productservice.dto.UserCreationRequest;
import com.it18.microservice.productservice.dto.UserCreationResponse;

import java.util.UUID;

@Service
public class ProductServiceImpl {

    @Autowired
    private RestTemplate restTemplate;

    public OrderResponse createOrder(OrderRequest orderRequest){

        UserCreationRequest userCreationRequest = new UserCreationRequest();
        userCreationRequest.setAge(orderRequest.getAge());
        userCreationRequest.setFullname(orderRequest.getFullname());
        ResponseEntity<UserCreationResponse> userCreationResponse = restTemplate.postForEntity("http://localhost:5223/users",userCreationRequest, UserCreationResponse.class);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderId(UUID.randomUUID().toString());
        orderResponse.setUserId(userCreationResponse.getBody().getUserId());
        orderResponse.setMessage("Successfully created the product");

        return orderResponse;
    }
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
}
