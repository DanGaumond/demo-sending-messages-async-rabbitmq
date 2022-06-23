package com.example.demosendingmessagesasync.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String sku;
    private String name;
    private String description;

    @ToString.Exclude
    @ManyToOne
    private Order order;
}
