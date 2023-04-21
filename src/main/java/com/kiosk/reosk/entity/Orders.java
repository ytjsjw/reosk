package com.kiosk.reosk.entity;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

public class Orders {
    @Id
    private int oNum;
    private Date oDate;
    private int stock;
    private long totalPrice;

    @ManyToOne
    private Product code, name, price;

}
