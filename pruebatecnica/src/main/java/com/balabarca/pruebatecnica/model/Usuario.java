package com.balabarca.pruebatecnica.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombres;
    private String apellidos;
    private String nombreEmpresa;
    private String cargo;
    private String telefono;

    @Column(unique = true)
    private String email;
    private String password;

    @OneToMany(mappedBy = "creador", cascade = CascadeType.ALL)
    private List<Proyecto> proyectos;
}
