package com.kiosk.reosk.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

    private int pCode;
    @Id
    private String pName;
    private int price;


}
