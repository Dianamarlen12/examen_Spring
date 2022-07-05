package com.ids.examen2.model;

import javax.persistence.*;

@Entity
@Table(name= "airport")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idAirport;

    @Column(name = "name")
    private String name;

    public long getIdAirport() {
        return idAirport;
    }

    public void setIdAirport(long idAirport) {
        this.idAirport = idAirport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
