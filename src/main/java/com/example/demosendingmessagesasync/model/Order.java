package com.example.demosendingmessagesasync.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ToString
@Getter
@Setter
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String invoiceNumber;
    private Double total;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @ToString.Exclude
    @OneToMany
    private List<OrderItem> orderItemList = new ArrayList<>();
}
