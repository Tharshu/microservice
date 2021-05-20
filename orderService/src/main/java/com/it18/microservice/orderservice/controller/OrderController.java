package com.it18.microservice.orderservice.controller;


import com.it18.microservice.orderservice.dto.OrderRequest;
import com.it18.microservice.orderservice.dto.OrderResponse;
//import org.springframework.web.bind.annotation.*;
import com.it18.microservice.orderservice.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @PostMapping(consumes = "application/json", produces ="application/json")
    public @ResponseBody
    OrderResponse createorder(@RequestBody OrderRequest request) {

        System.out.println("Order Details : " + request);


        return orderService.createOrder(request);

    }

}
