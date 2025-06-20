package com.eventos.JConcert.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Entity
@Getter
@Setter
public class Evento {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private LocalDate date;
    private String location;
    private int chairsAvailable;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Entrada> entradas = new java.util.ArrayList<>();

    protected Evento() {}

    public Evento(String name, LocalDate date, String location, int chairsAvailable) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.chairsAvailable = chairsAvailable;
    }

    @Override
    public String toString() {
        return String.format(
                "Evento[id=%d, name='%s', location='%s']",
                id, name,location);
    }
}
