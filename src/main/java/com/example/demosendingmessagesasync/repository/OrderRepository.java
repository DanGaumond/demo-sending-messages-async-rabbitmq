package com.example.demosendingmessagesasync.repository;

import com.example.demosendingmessagesasync.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {}