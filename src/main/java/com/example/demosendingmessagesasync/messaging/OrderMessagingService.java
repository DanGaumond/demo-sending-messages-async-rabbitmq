package com.example.demosendingmessagesasync.messaging;

import com.example.demosendingmessagesasync.model.Order;

public interface OrderMessagingService {
    void sendOrder(Order order);
}
