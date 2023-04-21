package com.kiosk.reosk.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    private int pCode;
    private String pName;
    private int price;


}
