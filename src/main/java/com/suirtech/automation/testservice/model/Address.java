package com.suirtech.automation.testservice.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "test_addresses", schema = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name = "line1")
    private String line1;
    @Column(name = "line2")
    private String line2;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;


    public Address(){
        this.line1 = "SHEARATON";
        this.line2 = "BAS";
        this.city = "Dubai";
        this.country = "UAE";
    }

    public Address(String line1, String line2, String city, String country){
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.country = country;
    }
}
