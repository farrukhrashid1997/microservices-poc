package com.nagp.fac.api.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Facility {
    private int serviceId;
    private String name;
    private double standardPrice;
    private String location;

    public Facility(int serviceId, String name, double standardPrice) {
        this.serviceId = serviceId;
        this.name = name;
        this.standardPrice = standardPrice;
    }
}
