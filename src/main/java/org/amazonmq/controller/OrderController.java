package org.amazonmq.controller;

import jakarta.validation.Valid;
import org.amazonmq.model.Order;
import org.amazonmq.request.OrderRequest;
import org.amazonmq.service.OrderSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderSendService orderSendService;

    @PostMapping("/create")
    public Order create(@RequestBody @Valid OrderRequest orderRequest) {
        return orderSendService.create(orderRequest.getProducts());
    }
}
