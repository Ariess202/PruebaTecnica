package com.balabarca.pruebatecnica.controller;

import com.balabarca.pruebatecnica.model.Proyecto;
import com.balabarca.pruebatecnica.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/proyectos")

public class ProyectoController {

    @Autowired
    private ProyectoRepository proyectoRepository;

    @GetMapping
    public List<Proyecto> listarProyectos(){
        return proyectoRepository.findAll();
    }

    @GetMapping("/search")
    public List<Proyecto> buscarAvanzado(
            @RequestParam(required = false) String codigo,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String estado,
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha_inicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha_fin){
        return proyectoRepository.busquedaAvanzada(codigo, nombre, estado, categoria, fecha_inicio, fecha_fin);
    }

    @PostMapping
    public Proyecto crearProyecto(@RequestBody Proyecto proyecto){
        return proyectoRepository.save(proyecto);
    }
}
