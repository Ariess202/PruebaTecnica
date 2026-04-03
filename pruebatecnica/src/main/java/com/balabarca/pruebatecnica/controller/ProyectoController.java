package com.balabarca.pruebatecnica.controller;

import com.balabarca.pruebatecnica.model.Proyecto;
import com.balabarca.pruebatecnica.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Proyecto crearProyecto(@RequestBody Proyecto proyecto){
        return proyectoRepository.save(proyecto);
    }
}
