package models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Entrada {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private double precio;
    private String numeroDeEntrada; // El-2025-01-numerorandom

    public Entrada() {}

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evento_id")
    private Evento evento;



}
