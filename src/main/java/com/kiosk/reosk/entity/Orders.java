package com.kiosk.reosk.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_seq")
    @SequenceGenerator(name = "orders_seq", sequenceName = "orders_seq", allocationSize = 1)
    private int oNum;

    @Id
    @CreatedDate
    @Column(name = "oDate")
    private LocalDateTime oDate;
    private int stock;
    private long totalPrice;

    private long oPrice;
    private String oName;

    @PrePersist
    public void onPrePersist() {
        this.oDate = LocalDateTime.now();
    }

    @ManyToOne
    private Product product;

}
