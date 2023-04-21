package com.kiosk.reosk.entity;

import javax.persistence.Id;

public class Product {

    @Id
    private int pCode;
    private String pName;
    private int price;


}
