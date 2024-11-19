package com.example.parcialback.modelos.Contrato;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String identificador;

    @Column(nullable = true)
    private Double valor;

    @Column(nullable = true)
    private String nombreContratante;

    @Column(nullable = true)
    private String documentoContratante;

    @Column(nullable = true)
    private String nombreContratantista;

    @Column(nullable = true)
    private String documentoContratantista;

    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Date fechaInicial;

    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;
}