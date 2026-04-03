package com.balabarca.pruebatecnica.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data

public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;
    private String descripcion;
    private String codigo;
    private String icono_url;
    private String estado;

    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;

    private boolean compartir;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario creador;
}
