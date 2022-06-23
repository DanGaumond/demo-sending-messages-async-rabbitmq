package com.example.demosendingmessagesasync.messaging;

import com.example.demosendingmessagesasync.model.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {

    @Autowired
    public OrderListener() {
    }

    @RabbitListener(queues = "demo.order.queue")
    public void receiveOrder(Order order) {
        System.out.println("Received an Order!");
        System.out.println(order.toString());
    }

}
