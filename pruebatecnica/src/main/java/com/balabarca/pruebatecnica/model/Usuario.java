package com.balabarca.pruebatecnica.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false)
    private String nombres;

    @NotBlank(message = "El apellido es obligatorio")
    @Column(nullable = false)
    private String apellidos;

    @NotBlank(message = "El email es obligatorio")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String nombreEmpresa;
    private String cargo;
    private String telefono;
    private String foto_url;

    @OneToMany(mappedBy = "creador", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Proyecto> proyectos;
}
