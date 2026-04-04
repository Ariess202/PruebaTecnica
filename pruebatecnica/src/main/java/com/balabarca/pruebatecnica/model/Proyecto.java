package com.balabarca.pruebatecnica.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column(nullable = false)
    private String nombre;

    @NotBlank
    @Column(nullable = false)
    private String codigo;

    @NotBlank
    @Column(nullable = false)
    private String estado;

    @NotNull
    @Column(nullable = false)
    private LocalDate fecha_inicio;

    @NotNull
    @Column(nullable = false)
    private LocalDate fecha_fin;

    private String descripcion;
    private String categoria;
    private String icono_url;
    private boolean compartir;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonBackReference
    private Usuario creador;
}