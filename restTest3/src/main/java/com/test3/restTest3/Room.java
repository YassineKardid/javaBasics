package com.test3.restTest3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer number;
    @Column(name = "surface")
    private float surface;
    @ManyToOne
    @JoinColumn(name = "home_number", referencedColumnName = "number")
    @JsonIgnore
    private Home home;

    public Room() {
    }

    public Room(float surface, Home home) {
        this.surface = surface;
        this.home = home;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public float getSurface() {
        return surface;
    }

    public void setSurface(float surface) {
        this.surface = surface;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }
}
