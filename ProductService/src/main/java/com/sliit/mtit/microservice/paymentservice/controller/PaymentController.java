package com.sliit.mtit.microservice.paymentservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sliit.mtit.microservice.paymentservice.dto.UserRequest;
import com.sliit.mtit.microservice.paymentservice.dto.UserResponse;
import com.sliit.mtit.microservice.paymentservice.dto.paymentRequest;
import com.sliit.mtit.microservice.paymentservice.dto.paymentResponse;
import com.sliit.mtit.microservice.paymentservice.impl.PaymentServiceImpl;

import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	PaymentServiceImpl paymentServiceImpl;
	
    @PostMapping(consumes = "application/json", produces = "application/json")
    public @ResponseBody paymentResponse makepayment(@RequestBody paymentRequest paymentRequest){

        System.out.println("makepayment Details : " + paymentRequest);


        return paymentServiceImpl.makepayment(paymentRequest);

    }
}
