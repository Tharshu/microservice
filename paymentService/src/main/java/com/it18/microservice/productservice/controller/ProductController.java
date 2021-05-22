package com.it18.microservice.productservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.it18.microservice.productservice.dto.OrderRequest;
import com.it18.microservice.productservice.dto.OrderResponse;
import com.it18.microservice.productservice.service.ProductServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping(consumes = "application/json", produces ="application/json")
    public @ResponseBody
    OrderResponse createorder(@RequestBody OrderRequest request) {
    	 System.out.println("Product Details : "+ request);

    	 OrderResponse orderResponse = new OrderResponse();
    	 orderResponse.setproductId(UUID.randomUUID().toString());
    	 orderResponse.setMessage("Successfully created the product");

        return orderResponse ;

    }

}
