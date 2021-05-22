package com.it18.microservice.orderservice.service;



import com.it18.microservice.orderservice.dto.OrderRequest;
import com.it18.microservice.orderservice.dto.OrderResponse;
import com.it18.microservice.orderservice.dto.UserCreationRequest;
import com.it18.microservice.orderservice.dto.UserCreationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class OrderServiceImpl {

    @Autowired
    private RestTemplate restTemplate;

    public OrderResponse createOrder(OrderRequest orderRequest){

        UserCreationRequest userCreationRequest = new UserCreationRequest();
        userCreationRequest.setAge(orderRequest.getAge());
        userCreationRequest.setFullname(orderRequest.getFullname());
        ResponseEntity<UserCreationResponse> userCreationResponse = restTemplate.postForEntity("http://localhost:8181/product",userCreationRequest, UserCreationResponse.class);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderId(UUID.randomUUID().toString());
        orderResponse.setproductId(userCreationResponse.getBody().getproductId());
        orderResponse.setMessage("Successfully created the Order");

        return orderResponse;
    }
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
}
