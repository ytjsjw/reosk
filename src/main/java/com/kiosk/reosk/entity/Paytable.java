package com.kiosk.reosk.entity;
import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "paytable")

public class Paytable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int oNum;
    private LocalDateTime currentTime;
    private String pCode;
    private String ponNum;   //성별 나이 
    private String   stock;
    private String   price;
 
    private String packige;
    private String age;

    // getters and setters
}