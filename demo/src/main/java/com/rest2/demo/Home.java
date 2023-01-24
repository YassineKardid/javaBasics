package com.rest2.demo;

import javax.persistence.*;

@Table(name = "home_model")
@Entity
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer number;
    @Column(name = "address")
    public String address;

    public Home(Integer number, String address) {
        this.number = number;
        this.address = address;
    }

    public Home() {
    }

    public Integer getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
