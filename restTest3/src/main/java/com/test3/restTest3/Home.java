package com.test3.restTest3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Table(name = "home")
@Entity
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer number;
    @Column(name = "address")
    public String address;
    @OneToMany(mappedBy = "home")
    //@JsonIgnore
    private Set<Room> rooms;

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public Home(String address) {
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

    @Override
    public String toString() {
        return "Home{" +
                "number=" + number +
                ", address='" + address + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}