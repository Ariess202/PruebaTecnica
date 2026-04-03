package com.balabarca.pruebatecnica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data

public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private String codigo;
    private String iconoUrl;
    private String estado;

    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;

    private boolean compartir;
}
