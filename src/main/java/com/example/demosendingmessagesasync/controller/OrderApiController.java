package com.example.demosendingmessagesasync.controller;

import com.example.demosendingmessagesasync.messaging.OrderMessagingService;
import com.example.demosendingmessagesasync.model.Order;
import com.example.demosendingmessagesasync.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/orders",
        produces="application/json")
@CrossOrigin(origins="http://localhost:8080")
public class OrderApiController {

    private final OrderMessagingService messageService;

    public OrderApiController(
            OrderMessagingService messageService) {
        this.messageService = messageService;
    }

    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void postOrder(@RequestBody Order order) {
        messageService.sendOrder(order);
    }
}
