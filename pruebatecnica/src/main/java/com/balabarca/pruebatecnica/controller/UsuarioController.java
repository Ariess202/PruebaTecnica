package com.balabarca.pruebatecnica.controller;

import com.balabarca.pruebatecnica.model.Usuario;
import com.balabarca.pruebatecnica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")

public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/registro")
    public Usuario registrarUsuario(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @GetMapping("/{id}")
    public Usuario buscarUsuarioPorId(@PathVariable long id){
        return usuarioRepository.findById(id).orElse(null);
    }
}
